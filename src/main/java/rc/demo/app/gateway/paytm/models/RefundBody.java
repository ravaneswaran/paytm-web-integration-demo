package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundBody {
	
	@XmlElement(name = "orderId")
	private String orderId;
	
	@XmlElement(name = "mid")
	private String merchantId;
	
	@XmlElement(name = "resultInfo")
	private RefundResultInfo paytmRefundResultInfo;
	
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

	public RefundResultInfo getPaytmRefundResultInfo() {
		return paytmRefundResultInfo;
	}

	public void setPaytmRefundResultInfo(RefundResultInfo paytmRefundResultInfo) {
		this.paytmRefundResultInfo = paytmRefundResultInfo;
	}
	
	

}
