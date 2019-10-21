package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addMoneyPayOption")
public class PaymentOptionAddMoneyPayOption {
	
	@XmlElement(name = "paymentModes")
	private String paymentModes;
	
	@XmlElement(name = "savedInstruments")
	private String savedInstruments;
	
	@XmlElement(name = "userProfileSarvatra")
	private String userProfileSarvatra;
	
	@XmlElement(name = "activeSubscriptions")
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
