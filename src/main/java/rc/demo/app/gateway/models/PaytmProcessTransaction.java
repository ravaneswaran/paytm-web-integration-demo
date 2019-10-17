package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-process-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmProcessTransaction {
	
	@XmlElement(name = "head")
	private PaytmProcessTransactionHead paytmProcessTransactionHead;
	
	@XmlElement(name = "body")
	private PaytmProcessTransactionBody paytmProcessTransactionBody;

	public PaytmProcessTransactionHead getPaytmProcessTransactionHead() {
		return paytmProcessTransactionHead;
	}

	public void setPaytmProcessTransactionHead(PaytmProcessTransactionHead paytmProcessTransactionHead) {
		this.paytmProcessTransactionHead = paytmProcessTransactionHead;
	}

	public PaytmProcessTransactionBody getPaytmProcessTransactionBody() {
		return paytmProcessTransactionBody;
	}

	public void setPaytmProcessTransactionBody(PaytmProcessTransactionBody paytmProcessTransactionBody) {
		this.paytmProcessTransactionBody = paytmProcessTransactionBody;
	}

}
