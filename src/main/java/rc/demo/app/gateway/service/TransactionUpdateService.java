package rc.demo.app.gateway.service;

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

import rc.demo.app.gateway.paytm.models.TransactionUpdate;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class TransactionUpdateService implements PaymentGatewayService<TransactionUpdate> {

	private static final Logger LOGGER = Logger.getLogger(TransactionUpdateService.class.getName());

	private String orderId;

	private String customerId;

	private String transactionToken;

	private String currency;

	private long amount;

	public TransactionUpdateService(String orderId, String customerId, String transactionToken, String currency,
			long amount) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.transactionToken = transactionToken;
		this.currency = currency;
		this.amount = amount;
	}

	@Override
	public TransactionUpdate serve() {
		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* body parameters */
		JSONObject body = new JSONObject();

		/* initialize an object for txnAmount */
		JSONObject txnAmount = new JSONObject();

		/* Transaction Amount Value */
		txnAmount.put("value", String.valueOf(this.amount));

		/* Transaction Amount Currency */
		txnAmount.put("currency", this.currency);

		/* initialize an object for userInfo */
		JSONObject userInfo = new JSONObject();

		/* unique id that belongs to your customer */
		userInfo.put("custId", this.customerId);

		/* put txnAmount object in body */
		body.put("txnAmount", txnAmount);

		/* put userInfo object in body */
		body.put("userInfo", userInfo);

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

		/*
		 * put transaction token here, this is same token which was generated by
		 * Initiate Transaction API
		 */
		head.put("txnToken", this.transactionToken);

		/* put generated checksum value here */
		head.put("signature", checksum);

		/* prepare JSON string for request */
		paytmParams.put("body", body);
		paytmParams.put("head", head);
		String post_data = paytmParams.toString();

		/* for Staging */
		URL url = null;
		try {
			String urlString = String.format(
					"https://securegw-stage.paytm.in/theia/api/v1/updateTransactionDetail?mid=%s&orderId=%s",
					ApplicationProperties.getMerchantId(), this.orderId);
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		/* for Production */
		// URL url = new
		// URL("https://securegw.paytm.in/theia/api/v1/updateTransactionDetail?mid=YOUR_MID_HERE&orderId=YOUR_ORDER_ID");

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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-transaction-update", responseData);
			LOGGER.info(String.format("PAYTM TRANSACTION UPDATE STRING : %s", paytmTransactionString));

			JAXBUnMarshaller<TransactionUpdate> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, TransactionUpdate.class);
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
