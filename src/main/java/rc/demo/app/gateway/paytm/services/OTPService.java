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

import rc.demo.app.LogMessageDecorator;
import rc.demo.app.gateway.paytm.models.SendOTP;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class OTPService implements PaymentGatewayService<SendOTP> {

	private static final Logger LOGGER = Logger.getLogger(OTPService.class.getName());

	private String orderId;

	private String transactionToken;

	private String mobileNumber;

	public OTPService(String orderId, String transactionToken, String mobileNumber) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public SendOTP serve() {

		JSONObject head = new JSONObject();
		head.put("clientId", "C11");
		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("channelId", "WEB");
		head.put("txnToken", this.transactionToken);

		JSONObject body = new JSONObject();
		body.put("mobileNumber", this.mobileNumber);

		JSONObject paytmParams = new JSONObject();
		paytmParams.put("head", head);
		paytmParams.put("body", body);

		// for staging
		URL url = null;
		try {
			String urlString = String.format(ApplicationProperties.getSendOTPAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId);
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		// URL transactionURL = new URL("https://securegw.paytm.in/login/sendOtp?mid=" +
		// MERCHANT_MID + "&orderId=" + orderId); // for production

		String postData = paytmParams.toString();

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
			requestWriter.writeBytes(postData);
			requestWriter.close();
			String responseData = "";
			InputStream is = connection.getInputStream();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
			if ((responseData = responseReader.readLine()) != null) {
				LOGGER.info(String.format("RESPONSE DATA : %s", responseData));
			}
			responseReader.close();

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-send-otp", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM SEND OTP STRING : %s", paytmTransactionString)));

			JAXBUnMarshaller<SendOTP> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, SendOTP.class);
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
