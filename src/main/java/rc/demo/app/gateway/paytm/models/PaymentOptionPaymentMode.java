package rc.demo.app.gateway.paytm.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paymentMode")
public class PaymentOptionPaymentMode {
	
	@XmlElement(name = "displayName")
	private String displayName;
	
	@XmlElement(name = "feeAmount")
	private String feeAmount;
	
	@XmlElement(name = "taxAmount")
	private String taxAmount;
	
	@XmlElement(name = "totalTransactionAmount")
	private String totalTransactionAmount;
	
	@XmlElement(name = "priority")
	private String priority;
	
	@XmlElement(name = "onboarding")
	private boolean onboarding;
	
	@XmlElement(name = "paymentMode")
	private String paymentMode;
	
	@XmlElement(name = "isHybirdDisabled")
	private boolean isHybirdDisabled;
	
	@XmlElement(name = "isDisabled")
	private IsDisabled isDisabled;
	
	@XmlElement(name = "paymentChannelOption")
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
