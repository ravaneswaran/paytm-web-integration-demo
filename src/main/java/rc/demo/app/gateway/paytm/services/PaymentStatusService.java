package rc.demo.app.gateway.paytm.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import rc.demo.app.LogMessageDecorator;
import rc.demo.app.gateway.paytm.models.PaymentStatus;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class PaymentStatusService implements PaymentGatewayService<PaymentStatus> {

	private static final Logger LOGGER = Logger.getLogger(PaymentStatusService.class.getName());
	
	private String orderId;
	
	public PaymentStatusService(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public PaymentStatus serve() {
		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* body parameters */
		JSONObject body = new JSONObject();

		/*
		 * Find your MID in your Paytm Dashboard at
		 * https://dashboard.paytm.com/next/apikeys
		 */
		body.put("mid", ApplicationProperties.getMerchantId());

		/* Enter your order id which needs to be check status for */
		body.put("orderId", this.orderId);

		/**
		 * Generate checksum by parameters we have in body You can get Checksum JAR from
		 * https://developer.paytm.com/docs/checksum/ Find your Merchant Key in your
		 * Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
		 */
		String checksum = "";
		try {
			checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
					.genrateCheckSum(ApplicationProperties.getMerchantKey(), body.toString());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		/* head parameters */
		JSONObject head = new JSONObject();

		/* put generated checksum value here */
		head.put("signature", checksum);

		/* prepare JSON string for request */
		paytmParams.put("body", body);
		paytmParams.put("head", head);
		String post_data = paytmParams.toString();

		/* for Staging */
		URL url = null;
		try {
			url = new URL(ApplicationProperties.getPaymentStatusAPIEndPoint());
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		/* for Production */
		// URL url = new
		// URL("https://securegw.paytm.in/merchant-status/api/v1/getPaymentStatus");

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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-payment-status", responseData);
			LOGGER.info(LogMessageDecorator.decorateInfo(String.format("PAYTM PAYMENT STATUS STRING : %s", paytmTransactionString)));

			JAXBUnMarshaller<PaymentStatus> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, PaymentStatus.class);

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
