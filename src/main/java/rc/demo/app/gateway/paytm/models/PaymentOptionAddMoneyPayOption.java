package rc.demo.app.gateway.paytm.models;

public class PaymentOptionAddMoneyPayOption {
	
	private String paymentModes;
	
	private String savedInstruments;
	
	private String userProfileSarvatra;
	
	private String activeSubscriptions;

	public String getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(String paymentModes) {
		this.paymentModes = paymentModes;
	}

	public String getSavedInstruments() {
		return savedInstruments;
	}

	public void setSavedInstruments(String savedInstruments) {
		this.savedInstruments = savedInstruments;
	}

	public String getUserProfileSarvatra() {
		return userProfileSarvatra;
	}

	public void setUserProfileSarvatra(String userProfileSarvatra) {
		this.userProfileSarvatra = userProfileSarvatra;
	}

	public String getActiveSubscriptions() {
		return activeSubscriptions;
	}

	public void setActiveSubscriptions(String activeSubscriptions) {
		this.activeSubscriptions = activeSubscriptions;
	}
}
