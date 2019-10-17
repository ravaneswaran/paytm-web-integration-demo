package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-payment-status")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentStatus {
	
	@XmlElement(name = "head")
	private PaymentStatusHead paymentStatusHead;
	
	@XmlElement(name = "body")
	private PaymentStatusBody paymentStatusBody;

	public PaymentStatusHead getPaymentStatusHead() {
		return paymentStatusHead;
	}

	public void setPaymentStatusHead(PaymentStatusHead paymentStatusHead) {
		this.paymentStatusHead = paymentStatusHead;
	}

	public PaymentStatusBody getPaymentStatusBody() {
		return paymentStatusBody;
	}

	public void setPaymentStatusBody(PaymentStatusBody paymentStatusBody) {
		this.paymentStatusBody = paymentStatusBody;
	}
}
