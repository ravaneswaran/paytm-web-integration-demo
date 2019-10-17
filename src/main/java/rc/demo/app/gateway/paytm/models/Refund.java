package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-refund")
@XmlAccessorType(XmlAccessType.FIELD)
public class Refund {
	
	@XmlElement(name = "head")
	private RefundHead paytmRefundHead;
	
	@XmlElement(name = "body")
	private RefundBody paytmRefundBody;

	public RefundHead getPaytmRefundHead() {
		return paytmRefundHead;
	}

	public void setPaytmRefundHead(RefundHead paytmRefundHead) {
		this.paytmRefundHead = paytmRefundHead;
	}

	public RefundBody getPaytmRefundBody() {
		return paytmRefundBody;
	}

	public void setPaytmRefundBody(RefundBody paytmRefundBody) {
		this.paytmRefundBody = paytmRefundBody;
	}
}
