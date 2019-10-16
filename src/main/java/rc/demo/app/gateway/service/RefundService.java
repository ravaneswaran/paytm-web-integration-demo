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

import rc.demo.app.gateway.models.PaytmRefund;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class RefundService implements PaymentGatewayService<PaytmRefund> {

	private static final Logger LOGGER = Logger.getLogger(RefundService.class.getName());

	private String orderId;

	private String paytmTransactionId;

	private String refundId;

	private long amountToRefund;

	public RefundService(String orderId, String paytmTransactionId, String refundId, long amountToRefund) {
		this.orderId = orderId;
		this.paytmTransactionId = paytmTransactionId;
		this.refundId = refundId;
		this.amountToRefund = amountToRefund;
	}

	@Override
	public PaytmRefund serve() {
		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* body parameters */
		JSONObject body = new JSONObject();

		/*
		 * Find your MID in your Paytm Dashboard at
		 * https://dashboard.paytm.com/next/apikeys
		 */
		body.put("mid", ApplicationProperties.getMerchantId());

		/* This has fixed value for refund transaction */
		body.put("txnType", "REFUND");

		/* Enter your order id for which refund needs to be initiated */
		body.put("orderId", this.orderId);

		/* Enter transaction id received from Paytm for respective successful order */
		body.put("txnId", this.paytmTransactionId);

		/* Enter numeric or alphanumeric unique refund id */
		body.put("refId", this.refundId);

		/* Enter amount that needs to be refunded, this must be numeric */
		body.put("refundAmount", String.valueOf(this.amountToRefund));

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
		 * This is used when you have two different merchant keys. In case you have only
		 * one please put - C11
		 */
		head.put("clientId", "C11");

		/* put generated checksum value here */
		head.put("signature", checksum);

		/* prepare JSON string for request */
		paytmParams.put("body", body);
		paytmParams.put("head", head);
		String post_data = paytmParams.toString();

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/refund/apply");
		/* for Staging */
		URL url = null;
		try {
			url = new URL("https://securegw-stage.paytm.in/refund/apply");
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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-refund", responseData);
			LOGGER.info(String.format("PAYTM REFUND STRING : %s", paytmTransactionString));

			JAXBUnMarshaller<PaytmRefund> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, PaytmRefund.class);
			
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
