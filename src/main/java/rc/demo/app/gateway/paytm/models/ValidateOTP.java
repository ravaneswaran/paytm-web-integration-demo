package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-validate-otp")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateOTP {
	
	@XmlElement(name = "head")
	private ValidateOTPHead validateOTPHead;
	
	@XmlElement(name = "body")
	private ValidateOTPBody validateOTPBody;

	public ValidateOTPHead getValidateOTPHead() {
		return validateOTPHead;
	}

	public void setValidateOTPHead(ValidateOTPHead validateOTPHead) {
		this.validateOTPHead = validateOTPHead;
	}

	public ValidateOTPBody getValidateOTPBody() {
		return validateOTPBody;
	}

	public void setValidateOTPBody(ValidateOTPBody validateOTPBody) {
		this.validateOTPBody = validateOTPBody;
	}
}
