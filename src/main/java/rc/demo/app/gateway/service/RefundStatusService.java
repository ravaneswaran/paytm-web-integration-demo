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

import rc.demo.app.gateway.models.PaytmRefundStatus;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class RefundStatusService implements PaymentGatewayService<PaytmRefundStatus> {

	private static final Logger LOGGER = Logger.getLogger(RefundStatusService.class.getName());

	private String orderId;

	private String refundId;

	public RefundStatusService(String orderId, String refundId) {
		this.orderId = orderId;
		this.refundId = refundId;
	}

	@Override
	public PaytmRefundStatus serve() {
		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* body parameters */
		JSONObject body = new JSONObject();

		/*
		 * Find your MID in your Paytm Dashboard at
		 * https://dashboard.paytm.com/next/apikeys
		 */
		body.put("mid", ApplicationProperties.getMerchantId());

		/* Enter your order id for which refund needs to be initiated */
		body.put("orderId", this.orderId);

		/* Enter refund id which was used for initiating refund */
		body.put("refId", this.refundId);

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

		/* for Staging */
		URL url = null;
		try {
			url = new URL("https://securegw-stage.paytm.in/v2/refund/status");
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/v2/refund/status");
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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-refund-status", responseData);
			LOGGER.info(String.format("PAYTM REFUND STATUS STRING : %s", paytmTransactionString));

			JAXBUnMarshaller<PaytmRefundStatus> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, PaytmRefundStatus.class);
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
