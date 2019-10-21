package rc.demo.app.gateway.paytm.models;

public class MerchantRemainingLimit {

	private String limitType;

	private String amount;

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
