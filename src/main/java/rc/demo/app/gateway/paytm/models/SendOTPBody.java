package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class SendOTPBody {
	
	@XmlElement(name = "resultInfo")
	private SendOTPBodyResultInfo sendOTPResultInfo;
	
	@XmlElement(name = "extraParamsMap")
	private SendOTPBodyExtraParamsMap sendOTPBodyExtraParamsMap;

	public SendOTPBodyResultInfo getSendOTPResultInfo() {
		return sendOTPResultInfo;
	}

	public void setSendOTPResultInfo(SendOTPBodyResultInfo sendOTPResultInfo) {
		this.sendOTPResultInfo = sendOTPResultInfo;
	}

	public SendOTPBodyExtraParamsMap getSendOTPBodyExtraParamsMap() {
		return sendOTPBodyExtraParamsMap;
	}

	public void setSendOTPBodyExtraParamsMap(SendOTPBodyExtraParamsMap sendOTPBodyExtraParamsMap) {
		this.sendOTPBodyExtraParamsMap = sendOTPBodyExtraParamsMap;
	}
}
