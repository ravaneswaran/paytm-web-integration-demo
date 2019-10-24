package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authMode")
public class BinDetailAuthMode {
	
	@XmlElement(name = "otp")
	private BinDetailOTP binDetailOTP;

	public BinDetailOTP getBinDetailOTP() {
		return binDetailOTP;
	}

	public void setBinDetailOTP(BinDetailOTP binDetailOTP) {
		this.binDetailOTP = binDetailOTP;
	}
}
