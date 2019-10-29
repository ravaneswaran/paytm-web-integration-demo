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

import rc.demo.app.gateway.paytm.models.NetBankingPaymentChannel;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class NetBankingPaymentChannelService implements PaymentGatewayService<NetBankingPaymentChannel> {

	private static final Logger LOGGER = Logger.getLogger(InitiateTransactionService.class.getName());

	private String orderId;

	private String transactionToken;

	public NetBankingPaymentChannelService(String orderId, String transactionToken) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
	}

	@Override
	public NetBankingPaymentChannel serve() {

		JSONObject head = new JSONObject();

		head.put("clientId", "C11");
		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("channelId", "WEB");
		head.put("txnToken", this.transactionToken);

		JSONObject body = new JSONObject();

		body.put("type", "MERCHANT");

		JSONObject paytmParams = new JSONObject();

		paytmParams.put("head", head);
		paytmParams.put("body", body);

		String postData = paytmParams.toString();
		
		LOGGER.info(String.format("REQUST DATA : %s", postData));

		/* for Staging */
		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getNetBankingPaymentChannelAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		/* for production */
		// https:https://securegw.paytm.in/theia/api/v1/fetchNBPaymentChannels?mid=%s&orderId=%s

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

			String paytmTransactionString = String.format("{\"%s\":%s}", "paytm-nb-payment-channel", responseData);
			LOGGER.info(String.format("PAYTM NB PAYMENT CHANNEL STRING : %s", paytmTransactionString));

			JAXBUnMarshaller<NetBankingPaymentChannel> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmTransactionString, NetBankingPaymentChannel.class);
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
