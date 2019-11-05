package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-direct-bank-request")
public class DirectBankRequest {
	
	@XmlElement(name = "head")
	private DirectBankRequestHead directBankRequestHead;
	
	@XmlElement(name = "body")
	private DirectBankRequestBody directBankRequestBody;

	public DirectBankRequestHead getDirectBankRequestHead() {
		return directBankRequestHead;
	}

	public void setDirectBankRequestHead(DirectBankRequestHead directBankRequestHead) {
		this.directBankRequestHead = directBankRequestHead;
	}

	public DirectBankRequestBody getDirectBankRequestBody() {
		return directBankRequestBody;
	}

	public void setDirectBankRequestBody(DirectBankRequestBody directBankRequestBody) {
		this.directBankRequestBody = directBankRequestBody;
	}
}
