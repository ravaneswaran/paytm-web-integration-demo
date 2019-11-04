package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-balance-info")
public class BalanceInfo {
	
	@XmlElement(name = "head")
	private BalanceInfoHead balanceInfoHead;
	
	@XmlElement(name = "body")
	private BalanceInfoBody balanceInfoBody;

	public BalanceInfoHead getBalanceInfoHead() {
		return balanceInfoHead;
	}

	public void setBalanceInfoHead(BalanceInfoHead balanceInfoHead) {
		this.balanceInfoHead = balanceInfoHead;
	}

	public BalanceInfoBody getBalanceInfoBody() {
		return balanceInfoBody;
	}

	public void setBalanceInfoBody(BalanceInfoBody balanceInfoBody) {
		this.balanceInfoBody = balanceInfoBody;
	}
}
