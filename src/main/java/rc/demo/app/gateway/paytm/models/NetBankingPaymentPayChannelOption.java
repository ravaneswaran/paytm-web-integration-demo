package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payChannelOption")
public class NetBankingPaymentPayChannelOption {
	
	@XmlElement(name = "iconUrl")
	private String iconUrl;
	
	@XmlElement(name = "balanceInfo")
	private String balanceInfo;
	
	@XmlElement(name = "isHybirdDisabled")
	private boolean isHybirdDisabled;
	
	@XmlElement(name = "isDisabled")
	private NetBankingPaymentPayChannelOptionIsDisabled isDisabled;
	
	@XmlElement(name = "hasLowAccess")
	private NetBankingPaymentPayChannelOptionHasLowAccess hasLowAccess;

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getBalanceInfo() {
		return balanceInfo;
	}

	public void setBalanceInfo(String balanceInfo) {
		this.balanceInfo = balanceInfo;
	}

	public boolean isHybirdDisabled() {
		return isHybirdDisabled;
	}

	public void setHybirdDisabled(boolean isHybirdDisabled) {
		this.isHybirdDisabled = isHybirdDisabled;
	}

	public NetBankingPaymentPayChannelOptionIsDisabled getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(NetBankingPaymentPayChannelOptionIsDisabled isDisabled) {
		this.isDisabled = isDisabled;
	}

	public NetBankingPaymentPayChannelOptionHasLowAccess getHasLowAccess() {
		return hasLowAccess;
	}

	public void setHasLowAccess(NetBankingPaymentPayChannelOptionHasLowAccess hasLowAccess) {
		this.hasLowAccess = hasLowAccess;
	}
}
