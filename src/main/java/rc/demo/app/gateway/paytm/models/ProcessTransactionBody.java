package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessTransactionBody {

	@XmlElement(name = "resultInfo")
	private ProcessTransactionBodyResultInfo paytmProcessTransactionBodyResultInfo;

	@XmlElement(name = "txnInfo")
	private ProcessTransactionBodyTransactionInfo paytmProcessTransactionBodyTransactionInfo;

	@XmlElement(name = "callBackUrl")
	private String callBackUrl;

	public ProcessTransactionBodyResultInfo getPaytmProcessTransactionBodyResultInfo() {
		return paytmProcessTransactionBodyResultInfo;
	}

	public void setPaytmProcessTransactionBodyResultInfo(
			ProcessTransactionBodyResultInfo paytmProcessTransactionBodyResultInfo) {
		this.paytmProcessTransactionBodyResultInfo = paytmProcessTransactionBodyResultInfo;
	}

	public ProcessTransactionBodyTransactionInfo getPaytmProcessTransactionBodyTransactionInfo() {
		return paytmProcessTransactionBodyTransactionInfo;
	}

	public void setPaytmProcessTransactionBodyTransactionInfo(
			ProcessTransactionBodyTransactionInfo paytmProcessTransactionBodyTransactionInfo) {
		this.paytmProcessTransactionBodyTransactionInfo = paytmProcessTransactionBodyTransactionInfo;
	}

	public String getCallBackUrl() {
		return callBackUrl;
	}

	public void setCallBackUrl(String callbackUrl) {
		this.callBackUrl = callbackUrl;
	}

}
