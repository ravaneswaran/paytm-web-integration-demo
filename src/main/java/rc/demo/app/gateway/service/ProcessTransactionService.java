package rc.demo.app.gateway.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import rc.demo.app.gateway.paytm.models.ProcessTransaction;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class ProcessTransactionService implements PaymentGatewayService<ProcessTransaction> {

	private static final Logger LOGGER = Logger.getLogger(RefundService.class.getName());

	private String orderId;

	private String transactionToken;

	private String paymentMode;

	private String authMode;

	private String cardInfo;

	public ProcessTransactionService(String orderId, String transactionToken, String paymentMode, String authMode,
			String cardInfo) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
		this.paymentMode = paymentMode;
		this.authMode = authMode;
		this.cardInfo = cardInfo;
	}

	@Override
	public ProcessTransaction serve() {

		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* head parameters */
		JSONObject head = new JSONObject();

		/*
		 * the client id, if you have two merchant id then replace it with C12 else the
		 * what is given is good to go
		 */
		head.put("clientId", "C11");

		/* the version */
		head.put("version", "v1");

		/* the timestamp of the request */
		head.put("requestTimestamp", System.currentTimeMillis());

		/* the channel id, WAP in case of mobile */
		head.put("channelId", "WEB");

		/* the transaction token generated as part of the initiate transaction */
		head.put("txnToken", this.transactionToken);

		/* body parameters */
		JSONObject body = new JSONObject();

		/* the request type */
		head.put("requestType", "NATIVE");

		/* the merchant id */
		head.put("mid", ApplicationProperties.getMerchantId());

		/* the order id */
		head.put("orderId", this.orderId);

		/* payment mode , CreditCard or NetBanking */
		head.put("paymentMode", this.paymentMode);

		/* the authMode, OTP or others... */
		head.put("authMode", this.authMode);

		/* the card info, in case if the paymentMode is CreditCard */
		head.put("cardInfo", this.cardInfo);

		/* the payment flow */
		head.put("paymentFlow", "NONE");

		/* store or not to store */
		head.put("storeInstrument", "0");

		/* prepare JSON string for request */
		paytmParams.put("body", body);
		paytmParams.put("head", head);

		/* for production */
		/*
		 * https://securegw.paytm.in/theia/api/v1/processTransaction?mid=<mid>&orderId=<
		 * orderId>
		 */
		URL url = null;
		try {
			String urlString = String.format(
					"https://securegw-stage.paytm.in/theia/api/v1/processTransaction?mid=%s&orderId=%s",
					ApplicationProperties.getMerchantId(), this.orderId);
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		String post_data = paytmParams.toString();

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-process-transaction", responseData);
			LOGGER.info(String.format("PAYTM PROCESS TRANSACTION STRING : %s", paytmTransactionString));

			JAXBUnMarshaller<ProcessTransaction> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, ProcessTransaction.class);

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}
}
