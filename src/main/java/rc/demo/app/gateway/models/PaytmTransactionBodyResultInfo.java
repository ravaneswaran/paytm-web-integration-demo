package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resultInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransactionBodyResultInfo {
	
	@XmlElement(name = "resultStatus")
	private String resultStatus;
	
	@XmlElement(name = "resultCode")
	private String resultCode;
	
	@XmlElement(name = "resultMsg")
	private String resultMsg;

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
}
