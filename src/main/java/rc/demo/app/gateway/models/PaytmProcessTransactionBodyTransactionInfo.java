package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "txnInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmProcessTransactionBodyTransactionInfo {
	
	@XmlElement(name = "BANKTXNID")
	private String bankTransactionId;
	
	@XmlElement(name = "CHECKSUMHASH")
	private String checksumHash;
	
	@XmlElement(name = "CURRENCY")
	private String currency;
	
	@XmlElement(name = "MID")
	private String merchantId;
	
	@XmlElement(name = "ORDERID")
	private String orderId;
	
	@XmlElement(name = "RESPCODE")
	private String responseCode;
	
	@XmlElement(name = "RESPMSG")
	private String responseMessage;
	
	@XmlElement(name = "STATUS")
	private String status;
	
	@XmlElement(name = "TXNAMOUNT")
	private String transactionAmount;

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public String getChecksumHash() {
		return checksumHash;
	}

	public void setChecksumHash(String checksumHash) {
		this.checksumHash = checksumHash;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
}
