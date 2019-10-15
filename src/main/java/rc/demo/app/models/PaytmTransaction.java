package rc.demo.app.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransaction {
	
	@XmlElement(name = "head")
	private PaytmTransactionHead head;
	
	@XmlElement(name = "body")
	private PaytmTransactionBody body;

	public PaytmTransactionHead getHead() {
		return head;
	}

	public void setHead(PaytmTransactionHead head) {
		this.head = head;
	}

	public PaytmTransactionBody getBody() {
		return body;
	}

	public void setBody(PaytmTransactionBody body) {
		this.body = body;
	}
}
