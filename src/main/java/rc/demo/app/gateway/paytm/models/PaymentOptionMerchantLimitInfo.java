package rc.demo.app.gateway.paytm.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "merchantLimitInfo")
public class PaymentOptionMerchantLimitInfo {

	@XmlElement(name = "excludePaymodes")
	private String excludePaymodes;

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "paymentModes")
	private List<MerchantRemainingLimit> merchantRemainingLimits;

	public String getExcludePaymodes() {
		return excludePaymodes;
	}

	public void setExcludePaymodes(String excludePaymodes) {
		this.excludePaymodes = excludePaymodes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<MerchantRemainingLimit> getMerchantRemainingLimits() {
		return merchantRemainingLimits;
	}

	public void setMerchantRemainingLimits(List<MerchantRemainingLimit> merchantRemainingLimits) {
		this.merchantRemainingLimits = merchantRemainingLimits;
	}
}
