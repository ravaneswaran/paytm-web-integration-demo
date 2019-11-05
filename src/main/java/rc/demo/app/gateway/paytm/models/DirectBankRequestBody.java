package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class DirectBankRequestBody {
	
	@XmlElement(name = "resultInfo")
	private DirectBankRequestBodyResultInfo directBankRequestBodyResultInfo;
	
	@XmlElement(name = "txnInfo")
	private TransactionInfo transactionInfo;
	
	@XmlElement(name = "callBackUrl")
	private String callBackUrl;

	public DirectBankRequestBodyResultInfo getDirectBankRequestBodyResultInfo() {
		return directBankRequestBodyResultInfo;
	}

	public void setDirectBankRequestBodyResultInfo(DirectBankRequestBodyResultInfo directBankRequestBodyResultInfo) {
		this.directBankRequestBodyResultInfo = directBankRequestBodyResultInfo;
	}

	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}

	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	public String getCallBackUrl() {
		return callBackUrl;
	}

	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
}
