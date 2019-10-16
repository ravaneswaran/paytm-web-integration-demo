package rc.demo.app.gateway.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import rc.demo.app.gateway.models.PaytmTransactionStatus;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class TransactionStatusService implements PaymentGatewayService<PaytmTransactionStatus> {

	private static final Logger LOGGER = Logger.getLogger(TransactionStatusService.class.getName());

	private String orderId;

	public TransactionStatusService(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public PaytmTransactionStatus serve() {
		/* initialize a TreeMap object */
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();

		/*
		 * Find your MID in your Paytm Dashboard at
		 * https://dashboard.paytm.com/next/apikeys
		 */
		paytmParams.put("MID", ApplicationProperties.getMerchantId());

		/* Enter your order id which needs to be check status for */
		paytmParams.put("ORDERID", this.orderId);

		/**
		 * Generate checksum by parameters we have in body You can get Checksum JAR from
		 * https://developer.paytm.com/docs/checksum/ Find your Merchant Key in your
		 * Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
		 */
		String checksum = "";
		try {
			checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
					.genrateCheckSum(ApplicationProperties.getMerchantKey(), paytmParams);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		/* put generated checksum value here */
		paytmParams.put("CHECKSUMHASH", checksum);

		/* prepare JSON string for request */
		JSONObject obj = new JSONObject(paytmParams);
		String post_data = obj.toString();
		
		LOGGER.info(String.format("REQUST DATA : %s", post_data));

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/order/status");
		/* for Staging */
		URL url = null;
		try {
			url = new URL("https://securegw-stage.paytm.in/order/status");
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
			requestWriter.writeBytes(post_data);
			requestWriter.close();
			String responseData = "";
			InputStream is = connection.getInputStream();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
			if ((responseData = responseReader.readLine()) != null) {
				LOGGER.info(String.format("RESPONSE DATA : %s", responseData));
			}
			responseReader.close();
			
			String paytmTransactionStatusString = String.format("{\"%s\":%s}", "paytm-transaction-status", responseData);
			LOGGER.info(String.format("PAYTM TRANSACTION STRING : %s", paytmTransactionStatusString));
			
			JAXBUnMarshaller<PaytmTransactionStatus> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionStatusString, PaytmTransactionStatus.class);
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}
	
	static {
		Handler handlerObj = new ConsoleHandler();
		handlerObj.setLevel(Level.ALL);
		LOGGER.addHandler(handlerObj);
		LOGGER.setLevel(Level.ALL);
		LOGGER.setUseParentHandlers(false);
	}
}
