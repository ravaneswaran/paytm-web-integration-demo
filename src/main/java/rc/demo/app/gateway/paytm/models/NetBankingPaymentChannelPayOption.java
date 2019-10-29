package rc.demo.app.gateway.paytm.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nbPayOption")
public class NetBankingPaymentChannelPayOption {
	
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
	
	@XmlElement(name = "isHybridDisabled")
	private boolean isHybridDisabled;
	
	@XmlElement(name = "payChannelOptions")
	private List<NetBankingPaymentPayChannelOption> payChannelOptions;
	
	@XmlElement(name = "isDisabled")
	private NetBankingPaymentChannelPayOptionIsDisabled isDisabled;

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

	public boolean isHybridDisabled() {
		return isHybridDisabled;
	}

	public void setHybridDisabled(boolean isHybridDisabled) {
		this.isHybridDisabled = isHybridDisabled;
	}

	public List<NetBankingPaymentPayChannelOption> getPayChannelOptions() {
		return payChannelOptions;
	}

	public void setPayChannelOptions(List<NetBankingPaymentPayChannelOption> payChannelOptions) {
		this.payChannelOptions = payChannelOptions;
	}

	public NetBankingPaymentChannelPayOptionIsDisabled getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(NetBankingPaymentChannelPayOptionIsDisabled isDisabled) {
		this.isDisabled = isDisabled;
	}
}
