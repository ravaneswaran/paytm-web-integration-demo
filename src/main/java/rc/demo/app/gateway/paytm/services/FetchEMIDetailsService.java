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
import rc.demo.app.gateway.paytm.models.FetchEMIDetails;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class FetchEMIDetailsService implements PaymentGatewayService<FetchEMIDetails> {

	private static final Logger LOGGER = Logger.getLogger(FetchEMIDetailsService.class.getName());

	private String orderId;

	private String transactionToken;

	private String[] channelCodes;

	public FetchEMIDetailsService(String orderId, String transactionToken, String[] channelCodes) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
		this.channelCodes = channelCodes;
	}

	@Override
	public FetchEMIDetails serve() {

		JSONObject head = new JSONObject();

		head.put("clientId", "C11");
		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("channelId", "WEB");
		head.put("txnToken", this.transactionToken);

		JSONObject body = new JSONObject();

		StringBuffer channelCodesBuffer = new StringBuffer();
		for (String channelCode : this.channelCodes) {
			channelCodesBuffer.append(channelCode).append(",");
		}
		String channelCodeValStr = channelCodesBuffer.toString();

		body.put("channelCode", channelCodeValStr.substring(0, channelCodeValStr.length() - 1));

		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		paytmParams.put("head", head);
		paytmParams.put("body", body);

		/* for Staging */
		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getFetchEMIDetailsAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		// for production
		// URL transactionURL = new
		// URL("https://securegw.paytm.in/theia/api/v1/fetchEMIDetail?mid=" +
		// MERCHANT_MID + "&orderId=" + orderId); // for production
		
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

			String paytmFetchEMIDetailsString = String.format("{\"%s\":%s}", "emi-details", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM FETCH EMI DETAILS STRING : %s", paytmFetchEMIDetailsString)));

			JAXBUnMarshaller<FetchEMIDetails> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmFetchEMIDetailsString, FetchEMIDetails.class);
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
