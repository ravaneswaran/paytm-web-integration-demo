package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundHead {

	@XmlElement(name = "clientId")
	private String clientId;

	@XmlElement(name = "responseTimestamp")
	private String responseTimeStamp;

	@XmlElement(name = "signature")
	private String signature;

	@XmlElement(name = "version")
	private String version;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}

	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
