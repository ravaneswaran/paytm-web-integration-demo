package rc.demo.app.gateway.paytm.models;

import java.util.List;

public class PaymentOptionPaymentMode {
	
	private String displayName;
	
	private String feeAmount;
	
	private String taxAmount;
	
	private String totalTransactionAmount;
	
	private String priority;
	
	private boolean onboarding;
	
	private String paymentMode;
	
	private boolean isHybirdDisabled;
	
	private IsDisabled isDisabled;
	
	private List<PayChannelOption> payChannelOptions;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(String totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isOnboarding() {
		return onboarding;
	}

	public void setOnboarding(boolean onboarding) {
		this.onboarding = onboarding;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public boolean isHybirdDisabled() {
		return isHybirdDisabled;
	}

	public void setHybirdDisabled(boolean isHybirdDisabled) {
		this.isHybirdDisabled = isHybirdDisabled;
	}

	public IsDisabled getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(IsDisabled isDisabled) {
		this.isDisabled = isDisabled;
	}

	public List<PayChannelOption> getPayChannelOptions() {
		return payChannelOptions;
	}

	public void setPayChannelOptions(List<PayChannelOption> payChannelOptions) {
		this.payChannelOptions = payChannelOptions;
	}
}
