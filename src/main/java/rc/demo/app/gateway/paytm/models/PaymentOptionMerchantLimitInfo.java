package rc.demo.app.gateway.paytm.models;

import java.util.List;

public class PaymentOptionMerchantLimitInfo {

	private String excludePaymodes;

	private String message;

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
