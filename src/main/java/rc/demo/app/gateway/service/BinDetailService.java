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

import rc.demo.app.LogMessageDecorator;
import rc.demo.app.gateway.paytm.models.BinDetail;
import rc.demo.app.properties.ApplicationProperties;
import rc.demo.app.unmarshaller.JAXBUnMarshaller;

public class BinDetailService implements PaymentGatewayService<BinDetail> {

	private static final Logger LOGGER = Logger.getLogger(BinDetailService.class.getName());

	private String orderId;

	private String transactionToken;
	
	private String bin;
	
	private String paymentMode;
	
	private String emiType;
	
	private String channelCode;
	
	private String transactionType;
	
	private String isEmiDetail;

	public BinDetailService(String orderId, String transactionToken, String bin, String paymentMode, String emiType,
			String channelCode, String transactionType, String isEmiDetail) {
		this.orderId = orderId;
		this.transactionToken = transactionToken;
		this.bin = bin;
		this.paymentMode  = paymentMode;
		this.emiType = emiType;
		this.channelCode = channelCode;
		this.transactionType = transactionType;
		this.isEmiDetail = isEmiDetail;
	}
	
	public BinDetailService(String orderId, String transactionToken, String bin) {
		this(orderId, transactionToken, bin, null, null, null, null, null);
	}

	@Override
	public BinDetail serve() {

		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* initialize an object */
		JSONObject head = new JSONObject();

		head.put("version", "v1");
		head.put("requestTimestamp", System.currentTimeMillis());
		head.put("channelId", "WEB");
		head.put("txnToken", this.transactionToken);
		
		/* initialize an object */
		JSONObject body = new JSONObject();

		body.put("bin", this.bin);
		
		paytmParams.put("head", head);
		paytmParams.put("body", body);

		String post_data = paytmParams.toString();

		LOGGER.info(String.format("REQUST DATA : %s", post_data));

		/* for Staging */
		URL url = null;
		try {
			url = new URL(String.format(ApplicationProperties.getBinDetailAPIEndPoint(),
					ApplicationProperties.getMerchantId(), this.orderId));
		} catch (MalformedURLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		/* for Production */
		// URL url = new
		// URL("https://securegw.paytm.in/subscription/create?mid=<mid>&orderId=<orderId>");

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

			String paytmSubscriptionString = String.format("{\"%s\":%s}", "paytm-bin-detail", responseData);
			LOGGER.info(LogMessageDecorator
					.decorateInfo(String.format("PAYTM BIN DETAIL STRING : %s", paytmSubscriptionString)));

			JAXBUnMarshaller<BinDetail> jaxbUnMarshaller = new JAXBUnMarshaller<>();
			return jaxbUnMarshaller.unMarshall(paytmSubscriptionString, BinDetail.class);

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
