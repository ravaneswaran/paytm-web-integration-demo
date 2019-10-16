package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransactionUpdateHead {
	
	/*{"responseTimestamp":"1571260458072",
	 * "version":"v1","signature":
	 * "sSyd35rT5QbThc7PSBpCsux3wgZOpokIiLTbTmyi3AOGL26PiM6/+A30nvqTRmfj+piui9rMp57hZ2OJvuKCsUvlnA552ewatUAlVjxF1bY="
	 * }*/
	
	@XmlElement(name = "responseTimestamp")
	private String responseTimestamp;
	
	@XmlElement(name = "version")
	private String version;
	
	@XmlElement(name = "signature")
	private String signature;

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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
