package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "binDetail")
public class BinDetailBinDetail {
	
	@XmlElement(name = "bin")
	private String bin;
	
	@XmlElement(name = "issuingBank")
	private String issuingBank;
	
	@XmlElement(name = "issuingBankCode")
	private String issuingBankCode;
	
	@XmlElement(name = "paymentMode")
	private String paymentMode;
	
	@XmlElement(name = "channelName")
	private String channelName;
	
	@XmlElement(name = "channelCode")
	private String channelCode;
	
	@XmlElement(name = "cnMin")
	private String cnMin;
	
	@XmlElement(name = "cnMax")
	private String cnMax;
	
	@XmlElement(name = "cvvR")
	private String cvvR;
	
	@XmlElement(name = "cvvL")
	private String cvvL;
	
	@XmlElement(name = "expR")
	private String expR;
	
	@XmlElement(name = "isActive")
	private String isActive;
	
	@XmlElement(name = "isIndian")
	private String isIndian;

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getIssuingBankCode() {
		return issuingBankCode;
	}

	public void setIssuingBankCode(String issuingBankCode) {
		this.issuingBankCode = issuingBankCode;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getCnMin() {
		return cnMin;
	}

	public void setCnMin(String cnMin) {
		this.cnMin = cnMin;
	}

	public String getCnMax() {
		return cnMax;
	}

	public void setCnMax(String cnMax) {
		this.cnMax = cnMax;
	}

	public String getCvvR() {
		return cvvR;
	}

	public void setCvvR(String cvvR) {
		this.cvvR = cvvR;
	}

	public String getCvvL() {
		return cvvL;
	}

	public void setCvvL(String cvvL) {
		this.cvvL = cvvL;
	}

	public String getExpR() {
		return expR;
	}

	public void setExpR(String expR) {
		this.expR = expR;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsIndian() {
		return isIndian;
	}

	public void setIsIndian(String isIndian) {
		this.isIndian = isIndian;
	}
}
