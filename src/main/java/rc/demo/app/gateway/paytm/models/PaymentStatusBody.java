package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentStatusBody {
	
	@XmlElement(name = "resultInfo")
	private PaymentStatusBodyResultInfo paymentStatusBodyResultInfo;
	
	@XmlElement(name = "orderId")
	private String orderId;
	
	@XmlElement(name = "mid")
	private String merchantId;

	public PaymentStatusBodyResultInfo getPaymentStatusBodyResultInfo() {
		return paymentStatusBodyResultInfo;
	}

	public void setPaymentStatusBodyResultInfo(PaymentStatusBodyResultInfo paymentStatusBodyResultInfo) {
		this.paymentStatusBodyResultInfo = paymentStatusBodyResultInfo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
