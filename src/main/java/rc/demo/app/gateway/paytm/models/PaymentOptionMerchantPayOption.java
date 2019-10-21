package rc.demo.app.gateway.paytm.models;

import java.util.List;

public class PaymentOptionMerchantPayOption {
	
	private List<PaymentOptionPaymentMode> paymentOptionPaymentMode;
	
	private List<PaymentOptionSavedInstruments> paymentOptionSavedInstruments;
	
	private String userProfileSarvata;
	
	private String activeSubscriptions;

	public List<PaymentOptionPaymentMode> getPaymentOptionPaymentMode() {
		return paymentOptionPaymentMode;
	}

	public void setPaymentOptionPaymentMode(List<PaymentOptionPaymentMode> paymentOptionPaymentMode) {
		this.paymentOptionPaymentMode = paymentOptionPaymentMode;
	}

	public List<PaymentOptionSavedInstruments> getPaymentOptionSavedInstruments() {
		return paymentOptionSavedInstruments;
	}

	public void setPaymentOptionSavedInstruments(List<PaymentOptionSavedInstruments> paymentOptionSavedInstruments) {
		this.paymentOptionSavedInstruments = paymentOptionSavedInstruments;
	}

	public String getUserProfileSarvata() {
		return userProfileSarvata;
	}

	public void setUserProfileSarvata(String userProfileSarvata) {
		this.userProfileSarvata = userProfileSarvata;
	}

	public String getActiveSubscriptions() {
		return activeSubscriptions;
	}

	public void setActiveSubscriptions(String activeSubscriptions) {
		this.activeSubscriptions = activeSubscriptions;
	}
}
