package rc.demo.app.service.gateway;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.json.JSONObject;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import rc.demo.app.models.OrderTransaction;
import rc.demo.app.properties.ApplicationProperties;

public class PaytmOrderGatewayService {
	
	public static OrderTransaction createNewOrder(String userId, String orderId, long amount, String currency, int receiptNumber,
			int paymentCapture) throws IOException, JAXBException {
		
		/* initialize an object */
		JSONObject paytmParams = new JSONObject();

		/* body parameters */
		JSONObject body = new JSONObject();

		/* for custom checkout value is 'Payment' and for intelligent router is 'UNI_PAY' */
		body.put("requestType", "Payment");

		/* Find your MID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
		body.put("mid", ApplicationProperties.getMerchantId());

		/* Find your Website Name in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
		body.put("websiteName", "localhost");

		/* Enter your unique order id */
		body.put("orderId", orderId);

		/* on completion of transaction, we will send you the response on this URL */
		body.put("callbackUrl", String.format(ApplicationProperties.getCallbackURL(), orderId));

		/* initialize an object for txnAmount */
		JSONObject txnAmount = new JSONObject();

		/* Transaction Amount Value */
		txnAmount.put("value", amount);

		/* Transaction Amount Currency */
		txnAmount.put("currency", currency);

		/* initialize an object for userInfo */
		JSONObject userInfo = new JSONObject();

		/* unique id that belongs to your customer */
		userInfo.put("custId", userId);

		/* put txnAmount object in body */
		body.put("txnAmount", txnAmount);

		/* put userInfo object in body */
		body.put("userInfo", userInfo);

		/**
		* Generate checksum by parameters we have in body
		* You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
		* Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys 
		*/
		String checksum = "";
		try {
			checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(ApplicationProperties.getMerchantKey(), body.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* head parameters */
		JSONObject head = new JSONObject();

		/* put generated checksum value here */
		head.put("signature", checksum);

		/* prepare JSON string for request */
		paytmParams.put("body", body);
		paytmParams.put("head", head);
		String post_data = paytmParams.toString();

		/* for Staging */
		URL url = new URL(String.format(ApplicationProperties.getPaymentGatewayEndPointUrl(), ApplicationProperties.getMerchantId(), orderId));

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=YOUR_ORDER_ID");

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
		        System.out.append("Response: " + responseData);
		    }
		    // System.out.append("Request: " + post_data);
		    responseReader.close();
		} catch (Exception exception) {
		    exception.printStackTrace();
		}
		
		
		
		return null;
	}
	
	public static OrderTransaction fetchOrderTransaction(String orderId) {
		return null;
	}
}
