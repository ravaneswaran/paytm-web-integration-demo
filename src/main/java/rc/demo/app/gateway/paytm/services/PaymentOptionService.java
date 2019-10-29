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
import rc.demo.app.gateway.paytm.models.PaymentOption;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class PaymentOptionService implements PaymentGatewayService<PaymentOption> {

	private static final Logger LOGGER = Logger.getLogger(PaymentOptionService.class.getName());

	private String orderId;

	private String transactionToken;

	public PaymentOptionService(String orderId, String transactionToken) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
	}

	@Override
	public PaymentOption serve() {

		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		JSONObject head = new JSONObject();

		head.put("clientId", "C11");

		head.put("version", "v1");

		head.put("requestTimestamp", System.currentTimeMillis());

		head.put("channelId", "WEB");

		head.put("txnToken", this.transactionToken);

		paytmParams.put("head", head);

		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getPaymentOptionAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-payment-option", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM PAYMENT OPTION STRING : %s", paytmTransactionString)));

			JAXBUnMarshaller<PaymentOption> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, PaymentOption.class);
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
