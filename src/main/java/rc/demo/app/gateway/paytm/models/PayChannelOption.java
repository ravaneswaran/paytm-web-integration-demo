package rc.demo.app.gateway.paytm.models;

public class PayChannelOption {
	
	private String iconUrl;
	
	private String balanceInfo;
	
	private boolean isHybirdDisabled;
	
	private IsDisabled isDisabled;
	
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
