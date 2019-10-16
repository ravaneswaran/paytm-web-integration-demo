package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction-status")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransactionStatus {
		
	@XmlElement(name = "TXNID")
	private String transactionId;
	
	@XmlElement(name = "BANKTXNID")
	private String bankTransactionId;
	
	@XmlElement(name = "ORDERID")
	private String orderId;
	
	@XmlElement(name = "TXNAMOUNT")
	private String transactionAmount;
	
	@XmlElement(name = "STATUS")
	private String status;
	
	@XmlElement(name = "TXNTYPE")
	private String transactionType;
	
	@XmlElement(name = "GATEWAYNAME")
	private String gateWayName;
	
	@XmlElement(name = "RESPCODE")
	private String responseCode;
	
	@XmlElement(name = "RESPMSG")
	private String responseMessage;
	
	@XmlElement(name = "BANKNAME")
	private String bankName;
	
	@XmlElement(name = "MID")
	private String merchantId;
	
	@XmlElement(name = "PAYMENTMODE")
	private String paymentMode;
	
	@XmlElement(name = "REFUNDAMT")
	private String refundAmount;
	
	@XmlElement(name = "TXNDATE")
	private String transactionDate;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getGateWayName() {
		return gateWayName;
	}

	public void setGateWayName(String gateWayName) {
		this.gateWayName = gateWayName;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
