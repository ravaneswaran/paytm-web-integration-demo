package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {
	
	@XmlElement(name = "head")
	private TransactionHead head;
	
	@XmlElement(name = "body")
	private TransactionBody body;

	public TransactionHead getHead() {
		return head;
	}

	public void setHead(TransactionHead head) {
		this.head = head;
	}

	public TransactionBody getBody() {
		return body;
	}

	public void setBody(TransactionBody body) {
		this.body = body;
	}
}
