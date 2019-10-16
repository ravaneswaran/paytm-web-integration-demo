package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resultInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmRefundResultInfo {
	
	@XmlElement(name = "resultStatus")
	private String resultStatus;
	
	@XmlElement(name = "resultCode")
	private String resultCode;
	
	@XmlElement(name = "resultMsg")
	private String resultMessage;

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

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
