package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmProcessTransactionBody {

	@XmlElement(name = "resultInfo")
	private PaytmProcessTransactionBodyResultInfo paytmProcessTransactionBodyResultInfo;

	@XmlElement(name = "txnInfo")
	private PaytmProcessTransactionBodyTransactionInfo paytmProcessTransactionBodyTransactionInfo;

	@XmlElement(name = "callBackUrl")
	private String callBackUrl;

	public PaytmProcessTransactionBodyResultInfo getPaytmProcessTransactionBodyResultInfo() {
		return paytmProcessTransactionBodyResultInfo;
	}

	public void setPaytmProcessTransactionBodyResultInfo(
			PaytmProcessTransactionBodyResultInfo paytmProcessTransactionBodyResultInfo) {
		this.paytmProcessTransactionBodyResultInfo = paytmProcessTransactionBodyResultInfo;
	}

	public PaytmProcessTransactionBodyTransactionInfo getPaytmProcessTransactionBodyTransactionInfo() {
		return paytmProcessTransactionBodyTransactionInfo;
	}

	public void setPaytmProcessTransactionBodyTransactionInfo(
			PaytmProcessTransactionBodyTransactionInfo paytmProcessTransactionBodyTransactionInfo) {
		this.paytmProcessTransactionBodyTransactionInfo = paytmProcessTransactionBodyTransactionInfo;
	}

	public String getCallBackUrl() {
		return callBackUrl;
	}

	public void setCallBackUrl(String callbackUrl) {
		this.callBackUrl = callbackUrl;
	}

}
