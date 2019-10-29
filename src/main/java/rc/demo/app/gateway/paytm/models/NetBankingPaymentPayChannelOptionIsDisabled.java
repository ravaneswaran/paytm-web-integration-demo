package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "isDisabled")
public class NetBankingPaymentPayChannelOptionIsDisabled {

	@XmlElement(name = "status")
	private String status;

	@XmlElement(name = "msg")
	private String message;

	@XmlElement(name = "userAccountExist")
	private String userAccountExist;
	
	@XmlElement(name = "merchantAccept")
	private String merchantAccept;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserAccountExist() {
		return userAccountExist;
	}

	public void setUserAccountExist(String userAccountExist) {
		this.userAccountExist = userAccountExist;
	}

	public String getMerchantAccept() {
		return merchantAccept;
	}

	public void setMerchantAccept(String merchantAccept) {
		this.merchantAccept = merchantAccept;
	}
}
