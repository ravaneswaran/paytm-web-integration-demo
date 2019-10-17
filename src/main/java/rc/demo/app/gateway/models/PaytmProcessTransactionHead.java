package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmProcessTransactionHead {
	
	@XmlElement(name = "responseTimestamp")
	private String responseTimestamp;
	
	@XmlElement(name = "version")
	private String version;

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
