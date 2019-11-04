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
import rc.demo.app.gateway.paytm.models.BalanceInfo;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class BalanceInfoService implements PaymentGatewayService<BalanceInfo>{
	
	private static final Logger LOGGER = Logger.getLogger(BalanceInfoService.class.getName());
	
	private String orderId;
	
	private String transactionToken;
	
	public BalanceInfoService(String orderId, String transactionToken) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
	}

	@Override
	public BalanceInfo serve() {
		
		JSONObject head = new JSONObject();
		
		head.put("clientId", "C11");
		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("channelId", "WEB");
		head.put("txnToken", this.transactionToken);
		
		JSONObject body = new JSONObject();
		
		body.put("paymentMode", "BALANCE");
		
		JSONObject paytmParams = new JSONObject();
		
		paytmParams.put("head", head);
		paytmParams.put("body", body);
		
		String postData = paytmParams.toString();
		
		LOGGER.info(String.format("REQUST DATA : %s", postData));

		/* for Staging */
		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getBalanceInfoAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
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

			String paytmSubscriptionString = String.format("{\"%s\":%s}", "paytm-balance-info", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM BALANCE INFO STRING : %s", paytmSubscriptionString)));

			JAXBUnMarshaller<BalanceInfo> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmSubscriptionString, BalanceInfo.class);

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
