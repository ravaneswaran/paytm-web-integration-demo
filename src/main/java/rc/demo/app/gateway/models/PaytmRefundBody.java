package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmRefundBody {
	
	@XmlElement(name = "orderId")
	private String orderId;
	
	@XmlElement(name = "mid")
	private String merchantId;
	
	@XmlElement(name = "resultInfo")
	private PaytmRefundResultInfo paytmRefundResultInfo;
	
	@XmlElement(name = "txnId")
	private String transactionId;
	
	@XmlElement(name = "refundAmount")
	private String refundAmount;

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

	public PaytmRefundResultInfo getPaytmRefundResultInfo() {
		return paytmRefundResultInfo;
	}

	public void setPaytmRefundResultInfo(PaytmRefundResultInfo paytmRefundResultInfo) {
		this.paytmRefundResultInfo = paytmRefundResultInfo;
	}
	
	

}
