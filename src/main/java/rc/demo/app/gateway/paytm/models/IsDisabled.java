package rc.demo.app.gateway.paytm.models;

public class IsDisabled {

	private String status;

	private String message;

	private String userAccountExist;

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
