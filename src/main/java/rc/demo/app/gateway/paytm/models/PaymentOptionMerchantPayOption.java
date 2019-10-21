package rc.demo.app.gateway.paytm.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "merchantPayOption")
public class PaymentOptionMerchantPayOption {
	
	@XmlElement(name = "paymentMode")
	private List<PaymentOptionPaymentMode> paymentOptionPaymentMode;
	
	@XmlElement(name = "savedInstruments")
	private List<PaymentOptionSavedInstrument> paymentOptionSavedInstruments;
	
	@XmlElement(name = "userProfileSarvatra")
	private String userProfileSarvatra;
	
	@XmlElement(name = "activeSubscriptions")
	private String activeSubscriptions;

	public List<PaymentOptionPaymentMode> getPaymentOptionPaymentMode() {
		return paymentOptionPaymentMode;
	}

	public void setPaymentOptionPaymentMode(List<PaymentOptionPaymentMode> paymentOptionPaymentMode) {
		this.paymentOptionPaymentMode = paymentOptionPaymentMode;
	}

	public List<PaymentOptionSavedInstrument> getPaymentOptionSavedInstruments() {
		return paymentOptionSavedInstruments;
	}

	public void setPaymentOptionSavedInstruments(List<PaymentOptionSavedInstrument> paymentOptionSavedInstruments) {
		this.paymentOptionSavedInstruments = paymentOptionSavedInstruments;
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
