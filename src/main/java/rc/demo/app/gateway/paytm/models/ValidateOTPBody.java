package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateOTPBody {
	
	@XmlElement(name = "resultInfo")
	private ValidateOTPResultInfo validateOTPResultInfo;
	
	@XmlElement(name = "extraParamsMap")
	private ValidateOTPExtraParamsMap validateOTPExtraParamsMap;

	public ValidateOTPResultInfo getValidateOTPResultInfo() {
		return validateOTPResultInfo;
	}

	public void setValidateOTPResultInfo(ValidateOTPResultInfo validateOTPResultInfo) {
		this.validateOTPResultInfo = validateOTPResultInfo;
	}

	public ValidateOTPExtraParamsMap getValidateOTPExtraParamsMap() {
		return validateOTPExtraParamsMap;
	}

	public void setValidateOTPExtraParamsMap(ValidateOTPExtraParamsMap validateOTPExtraParamsMap) {
		this.validateOTPExtraParamsMap = validateOTPExtraParamsMap;
	}
}
