package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class BalanceInfoBody {
	
	@XmlElement(name = "resultInfo")
	private BalanceInfoBodyResultInfo balanceInfoBodyResultInfo;
	
	@XmlElement(name = "extraParamsMap")
	private BalanceInfoBodyExtraParamsMap balanceInfoBodyExtraParamsMap;

	public BalanceInfoBodyResultInfo getBalanceInfoBodyResultInfo() {
		return balanceInfoBodyResultInfo;
	}

	public void setBalanceInfoBodyResultInfo(BalanceInfoBodyResultInfo balanceInfoBodyResultInfo) {
		this.balanceInfoBodyResultInfo = balanceInfoBodyResultInfo;
	}

	public BalanceInfoBodyExtraParamsMap getBalanceInfoBodyExtraParamsMap() {
		return balanceInfoBodyExtraParamsMap;
	}

	public void setBalanceInfoBodyExtraParamsMap(BalanceInfoBodyExtraParamsMap balanceInfoBodyExtraParamsMap) {
		this.balanceInfoBodyExtraParamsMap = balanceInfoBodyExtraParamsMap;
	}
}
