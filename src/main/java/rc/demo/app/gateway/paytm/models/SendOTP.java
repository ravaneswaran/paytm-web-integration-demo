package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-send-otp")
public class SendOTP {
	
	@XmlElement(name = "head")
	private SendOTPHead sendOTPHead;
	
	@XmlElement(name = "body")
	private SendOTPBody sendOTPBody;

	public SendOTPHead getSendOTPHead() {
		return sendOTPHead;
	}

	public void setSendOTPHead(SendOTPHead sendOTPHead) {
		this.sendOTPHead = sendOTPHead;
	}

	public SendOTPBody getSendOTPBody() {
		return sendOTPBody;
	}

	public void setSendOTPBody(SendOTPBody sendOTPBody) {
		this.sendOTPBody = sendOTPBody;
	}
}
