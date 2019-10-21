package rc.demo.app.gateway.paytm.models;

public class PaymentOption {
	
	private PaymentOptionHead paymentOptionHead;
	
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