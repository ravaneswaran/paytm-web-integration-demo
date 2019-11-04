package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;

public class SendOTPHead {
	
	@XmlElement(name = "requestId")
	private String requestId;
	
	@XmlElement(name = "responseTimestamp")
	private String responseTimestamp;
	
	@XmlElement(name = "version")
	private String version;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getResponseTimestamp() {
		return responseTimestamp;
	}

	public void setResponseTimestamp(String responseTimestamp) {
		this.responseTimestamp = responseTimestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
