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
import rc.demo.app.gateway.paytm.models.DirectBankRequest;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class DirectBankRequestService implements PaymentGatewayService<DirectBankRequest> {

	private static final Logger LOGGER = Logger.getLogger(DirectBankRequestService.class.getName());

	private String orderId;

	private String transactionToken;

	private String otp;

	public DirectBankRequestService(String orderId, String transactionToken, String otp) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
		this.otp = otp;
	}

	@Override
	public DirectBankRequest serve() {

		JSONObject paytmParams = new JSONObject();
		
		paytmParams.put("txnToken", this.transactionToken);
		paytmParams.put("requestType", "submit");
		paytmParams.put("otp", this.otp);

		String postData = paytmParams.toString();

		/* for Staging */
		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getDirectBankRequestAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
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

			String paytmSubscriptionString = String.format("{\"%s\":%s}", "paytm-direct-bank-request", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM DIRECT BANK REQUEST STRING : %s", paytmSubscriptionString)));

			JAXBUnMarshaller<DirectBankRequest> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmSubscriptionString, DirectBankRequest.class);

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
