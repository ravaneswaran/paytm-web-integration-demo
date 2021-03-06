package rc.demo.app.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {

	private static final Logger LOGGER = Logger.getLogger(ApplicationProperties.class.getName());

	private static Properties paytmProperties;

	static {
		paytmProperties = System.getProperties();
		// loading the main property file
		try {
			paytmProperties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app.properties"));
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}

		// loading the environment specific property files

		// loading development environment specific property file
		String operationMode = paytmProperties.getProperty("operation.mode");

		if ("development".equals(operationMode)) {
			try {
				paytmProperties
						.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-dev.properties"));
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		} else if ("testing".equals(operationMode)) {
			try {
				paytmProperties
						.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-test.properties"));
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			try {
				paytmProperties
						.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-prod.properties"));
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}

	public ApplicationProperties() {
	}
	
	public static String getOperationMode() {
		return paytmProperties.getProperty("operation.mode");
	}

	public static String getValue(String key) {
		return paytmProperties.getProperty(key);
	}

	public static final String getMerchantId() {
		return paytmProperties.getProperty("merchant.id");
	}

	public static final String getMerchantKey() {
		return paytmProperties.getProperty("merchant.key");
	}

	public static final String getTransactionCallbackURL() {
		return paytmProperties.getProperty("paytm.transaction.callback.url");
	}
	
	public static final String getSubscriptionCallbackURL() {
		return paytmProperties.getProperty("paytm.subscription.callback.url");
	}
	
	public static final String getInitiateTransactionAPIEndPoint() {
		return paytmProperties.getProperty("paytm.initiate.transaction.api.endpoint");
	}
	
	public static final String getInitiateSubscriptionAPIEndPoint() {
		return paytmProperties.getProperty("paytm.initiate.subscription.api.endpoint");
	}
	
	public static final String getPaymentStatusAPIEndPoint() {
		return paytmProperties.getProperty("paytm.payment.status.api.endpoint");
	}
	
	public static final String getPaymentOptionAPIEndPoint() {
		return paytmProperties.getProperty("paytm.payment.option.api.endpoint");
	}
	
	public static final String getRefundAPIEndPoint() {
		return paytmProperties.getProperty("paytm.refund.api.endpoint");
	}
	
	public static final String getRefundStatusAPIEndPoint() {
		return paytmProperties.getProperty("paytm.refund.status.api.endpoint");
	}
	
	public static final String getProcessTransactionAPIEndPoint() {
		return paytmProperties.getProperty("paytm.process.transaction.api.endpoint");
	}
	
	public static final String getTransactionStatusAPIEndPoint() {
		return paytmProperties.getProperty("paytm.transaction.status.api.endpoint");
	}
	
	public static final String getTransactionUpdateAPIEndPoint() {
		return paytmProperties.getProperty("paytm.transaction.update.api.endpoint");
	}
	
	public static final String getBinDetailAPIEndPoint() {
		return paytmProperties.getProperty("paytm.bin.detail.api.endpoint");
	}

	public static String getNetBankingPaymentChannelAPIEndPoint() {
		return paytmProperties.getProperty("paytm.netbanking.payment.channel.api.endpoint");
	}

	public static String getFetchEMIDetailsAPIEndPoint() {
		return paytmProperties.getProperty("paytm.fetch.emi.details.api.endpoint");
	}
	
	public static String getSendOTPAPIEndPoint() {
		return paytmProperties.getProperty("paytm.sent.otp.api.endpoint");
	}

	public static String getValidateOTPAPIEndPoint() {
		return paytmProperties.getProperty("paytm.validate.otp.api.endpoint");
	}

	public static String getBalanceInfoAPIEndPoint() {
		return paytmProperties.getProperty("paytm.balance.info.api.endpoint");
	}

	public static String getDirectBankRequestAPIEndPoint() {
		return paytmProperties.getProperty("paytm.direct.bank.request.api.endpoint");
	}

	public static String getCancelSubscriptionAPIEndPoint() {
		return paytmProperties.getProperty("paytm.cancel.subscription.api.endpoint");
	}
}
