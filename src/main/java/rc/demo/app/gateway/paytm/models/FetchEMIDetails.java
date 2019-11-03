package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emi-details")
public class FetchEMIDetails {
	
	@XmlElement(name = "head")
	private EMIDetailsHead eMIDetailsHead;
	
	@XmlElement(name = "body")
	private EMIDetailsBody eMIDetailsBody;

	public EMIDetailsHead geteMIDetailsHead() {
		return eMIDetailsHead;
	}

	public void seteMIDetailsHead(EMIDetailsHead eMIDetailsHead) {
		this.eMIDetailsHead = eMIDetailsHead;
	}

	public EMIDetailsBody geteMIDetailsBody() {
		return eMIDetailsBody;
	}

	public void seteMIDetailsBody(EMIDetailsBody eMIDetailsBody) {
		this.eMIDetailsBody = eMIDetailsBody;
	}
}
