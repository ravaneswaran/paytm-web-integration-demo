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
import rc.demo.app.gateway.paytm.models.CancelSubscription;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class CancelSubscriptionService implements PaymentGatewayService<CancelSubscription> {

	private static final Logger LOGGER = Logger.getLogger(CancelSubscriptionService.class.getName());

	private String subscriptionId;

	private String tokenType;
	
	private String ssoToken;
	
	private String signature;

	public CancelSubscriptionService(String subscriptionId, String ssoToken, String signature, String tokenType) {
		this.subscriptionId = subscriptionId;
		this.tokenType = tokenType;
		this.ssoToken = ssoToken;
		this.signature = signature;
	}

	@Override
	public CancelSubscription serve() {

		JSONObject head = new JSONObject();

		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("tokenType", CancelSubscription.TOKEN_TYPE_AES);
		if (CancelSubscription.TOKEN_TYPE_AES.equals(this.tokenType)) {
			head.put("signature", this.signature);
		}

		JSONObject body = new JSONObject();

		body.put("mid", ApplicationProperties.getMerchantId());
		body.put("subsId", this.subscriptionId);
		if (CancelSubscription.TOKEN_TYPE_SSO.equals(this.tokenType)) {
			body.put("ssoToken", this.ssoToken);
		}

		JSONObject paytmParams = new JSONObject();

		paytmParams.put("head", head);
		paytmParams.put("body", body);

		String postData = paytmParams.toString();

		/* for Staging */
		URL url = null;
		try {
			url = new URL(ApplicationProperties.getCancelSubscriptionAPIEndPoint());
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

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

			String responseString = String.format("{\"%s\":%s}", "paytm-cancel-subscription", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM CANCEL SUBSCRIPTION STRING : %s", responseString)));

			JAXBUnMarshaller<CancelSubscription> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(responseString, CancelSubscription.class);

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
