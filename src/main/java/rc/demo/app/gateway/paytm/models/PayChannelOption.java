package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payChannelOptions")
public class PayChannelOption {
	
	@XmlElement(name = "iconUrl")
	private String iconUrl;
	
	@XmlElement(name = "balanceInfo")
	private String balanceInfo;
	
	@XmlElement(name = "isHybirdDisabled")
	private boolean isHybirdDisabled;
	
	@XmlElement(name = "isDisabled")
	private IsDisabled isDisabled;
	
	@XmlElement(name = "hasLowAccess")
	private HasLowAccess hasLowAccess;

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

	public IsDisabled getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(IsDisabled isDisabled) {
		this.isDisabled = isDisabled;
	}

	public HasLowAccess getHasLowAccess() {
		return hasLowAccess;
	}

	public void setHasLowAccess(HasLowAccess hasLowAccess) {
		this.hasLowAccess = hasLowAccess;
	}
}
