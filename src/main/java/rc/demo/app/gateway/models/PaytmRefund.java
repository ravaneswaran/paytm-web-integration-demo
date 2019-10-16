package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-refund")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmRefund {
	
	@XmlElement(name = "head")
	private PaytmRefundHead paytmRefundHead;
	
	@XmlElement(name = "body")
	private PaytmRefundBody paytmRefundBody;

	public PaytmRefundHead getPaytmRefundHead() {
		return paytmRefundHead;
	}

	public void setPaytmRefundHead(PaytmRefundHead paytmRefundHead) {
		this.paytmRefundHead = paytmRefundHead;
	}

	public PaytmRefundBody getPaytmRefundBody() {
		return paytmRefundBody;
	}

	public void setPaytmRefundBody(PaytmRefundBody paytmRefundBody) {
		this.paytmRefundBody = paytmRefundBody;
	}
}
