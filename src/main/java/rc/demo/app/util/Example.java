package rc.demo.app.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import com.paytm.merchant.models.PaymentStatusDetail;
import com.paytm.merchant.models.SDKResponse;
import com.paytm.merchant.models.Time;
import com.paytm.pg.Payment;
import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pg.utils.CommonUtil;

import rc.demo.app.properties.ApplicationProperties;

public class Example {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		/** Below code snippet shows how to initialize one time parameters for SDK */
		// Set Logger Level for Paytm SDK logs
		LibraryConstants.LOGGER.setLevel(Level.ALL);
		// setting log file path "/paytm/MyLogFile.log"
		try {
			FileHandler fh = null;
			// Make sure log file has write permission
			fh = new FileHandler("/paytm/MyLogFile.log");
			fh.setFormatter(new SimpleFormatter());
			LibraryConstants.LOGGER.addHandler(fh);
			// Removing console handler from logger
			LibraryConstants.LOGGER.setUseParentHandlers(false);
		} catch (IOException e) {
			LibraryConstants.LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(e.toString()), e);
		}
		// Mandatory Parameters for setting up merchant
		// Environment should be "STAGE" for Staging/Testing and "PROD" for Production.
		String env = LibraryConstants.STAGING_ENVIRONMENT;
		// below property are provided at the time of onboarding
		String mid = ApplicationProperties.getMerchantId();
		String key = ApplicationProperties.getMerchantKey();
		String clientId = "clientId";
		String website = "WEBSTAGING";
		// Setting Merchant's Mandatory Parameters
		MerchantProperties.initialize(env, mid, key, clientId, website);
		// callback URL
		String callbackUrl = "http://localhost:9090/PaytmNativeApiJavaIntegration/pgResponse.jsp";
		/** Setting Callback URL */
		MerchantProperties.setCallbackUrl(callbackUrl);
		/** Setting timeout for connection i.e. Connection Timeout */
		MerchantProperties.setConnectionTimeout(new Time(5, TimeUnit.MINUTES));

		/**
		 * Below code snippet shows how to get Payment Status form Paytm for a specific
		 * order Id.
		 */
		/** Unique order for each order request */
		String orderId = "1";
		Time readTimeout = new Time(5, TimeUnit.MINUTES);
		// PaymentStatusDetail object will have all the information required to make
		// getPaymentStatus call
		PaymentStatusDetail paymentStatusDetail = new PaymentStatusDetail.PaymentStatusDetailBuilder(orderId)
				.setReadTimeout(readTimeout).build();
		/**
		 * Making call to SDK method which will return the
		 * SDKResponse(NativePaymentStatusResponse) that holds Payment Status of any
		 * previous transaction.
		 */
		SDKResponse response = Payment.getPaymentStatus(paymentStatusDetail);
		System.out.println(response);
		
	}
}
