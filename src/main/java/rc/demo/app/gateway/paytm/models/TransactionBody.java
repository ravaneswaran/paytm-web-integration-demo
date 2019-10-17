package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionBody {
	
	@XmlElement(name = "txnToken")
	private String txnToken;
	
	@XmlElement(name = "isPromoCodeValid")
	private boolean isPromoCodeValid;
	
	@XmlElement(name = "authenticated")
	private boolean authenticated;
	
	private TransactionBodyResultInfo paytmTransactionBodyResultInfo;

	public String getTxnToken() {
		return txnToken;
	}

	public void setTxnToken(String txnToken) {
		this.txnToken = txnToken;
	}

	public boolean isPromoCodeValid() {
		return isPromoCodeValid;
	}

	public void setPromoCodeValid(boolean isPromoCodeValid) {
		this.isPromoCodeValid = isPromoCodeValid;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public TransactionBodyResultInfo getPaytmTransactionBodyResultInfo() {
		return paytmTransactionBodyResultInfo;
	}

	public void setPaytmTransactionBodyResultInfo(TransactionBodyResultInfo paytmTransactionBodyResultInfo) {
		this.paytmTransactionBodyResultInfo = paytmTransactionBodyResultInfo;
	}
}
