package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-payment-option")
public class PaymentOption {
	
	@XmlElement(name = "head")
	private PaymentOptionHead paymentOptionHead;
	
	@XmlElement(name = "body")
	private PaymentOptionBody paymentOptionBody;

	public PaymentOptionHead getPaymentOptionHead() {
		return paymentOptionHead;
	}

	public void setPaymentOptionHead(PaymentOptionHead paymentOptionHead) {
		this.paymentOptionHead = paymentOptionHead;
	}

	public PaymentOptionBody getPaymentOptionBody() {
		return paymentOptionBody;
	}

	public void setPaymentOptionBody(PaymentOptionBody paymentOptionBody) {
		this.paymentOptionBody = paymentOptionBody;
	}
}