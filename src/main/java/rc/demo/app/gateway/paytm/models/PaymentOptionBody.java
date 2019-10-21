package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PaymentOptionBody {

	@XmlElement(name = "walletOnly")
	private boolean walletOnly;

	@XmlElement(name = "zeroCostEmi")
	private boolean zeroCostEmi;

	@XmlElement(name = "pcfEnabled")
	private boolean pcfEnabled;

	@XmlElement(name = "nativeJsonRequestSupported")
	private boolean nativeJsonRequestSupported;

	@XmlElement(name = "activeMerchant")
	private boolean activeMerchant;

	@XmlElement(name = "onTheFlyKYCRequired")
	private boolean onTheFlyKYCRequired;

	@XmlElement(name = "paymentFlow")
	private String paymentFlow;

	@XmlElement(name = "resultInfo")
	private PaymentOptionResultInfo paymentOptionResultInfo;

	@XmlElement(name = "merchantPayOption")
	private PaymentOptionMerchantPayOption paymentOptionMerchantPayOption;

	@XmlElement(name = "addMoneyPayOption")
	private PaymentOptionAddMoneyPayOption paymentOptionAddMoneyPayOption;

	@XmlElement(name = "merchantLimitInfo")
	private PaymentOptionMerchantLimitInfo paymentOptionMerchantLimitInfo;

	public boolean isWalletOnly() {
		return walletOnly;
	}

	public void setWalletOnly(boolean walletOnly) {
		this.walletOnly = walletOnly;
	}

	public boolean isZeroCostEmi() {
		return zeroCostEmi;
	}

	public void setZeroCostEmi(boolean zeroCostEmi) {
		this.zeroCostEmi = zeroCostEmi;
	}

	public boolean isPcfEnabled() {
		return pcfEnabled;
	}

	public void setPcfEnabled(boolean pcfEnabled) {
		this.pcfEnabled = pcfEnabled;
	}

	public boolean isNativeJsonRequestSupported() {
		return nativeJsonRequestSupported;
	}

	public void setNativeJsonRequestSupported(boolean nativeJsonRequestSupported) {
		this.nativeJsonRequestSupported = nativeJsonRequestSupported;
	}

	public boolean isActiveMerchant() {
		return activeMerchant;
	}

	public void setActiveMerchant(boolean activeMerchant) {
		this.activeMerchant = activeMerchant;
	}

	public boolean isOnTheFlyKYCRequired() {
		return onTheFlyKYCRequired;
	}

	public void setOnTheFlyKYCRequired(boolean onTheFlyKYCRequired) {
		this.onTheFlyKYCRequired = onTheFlyKYCRequired;
	}

	public String getPaymentFlow() {
		return paymentFlow;
	}

	public void setPaymentFlow(String paymentFlow) {
		this.paymentFlow = paymentFlow;
	}

	public PaymentOptionResultInfo getPaymentOptionResultInfo() {
		return paymentOptionResultInfo;
	}

	public void setPaymentOptionResultInfo(PaymentOptionResultInfo paymentOptionResultInfo) {
		this.paymentOptionResultInfo = paymentOptionResultInfo;
	}

	public PaymentOptionMerchantPayOption getPaymentOptionMerchantPayOption() {
		return paymentOptionMerchantPayOption;
	}

	public void setPaymentOptionMerchantPayOption(PaymentOptionMerchantPayOption paymentOptionMerchantPayOption) {
		this.paymentOptionMerchantPayOption = paymentOptionMerchantPayOption;
	}

	public PaymentOptionAddMoneyPayOption getPaymentOptionAddMoneyPayOption() {
		return paymentOptionAddMoneyPayOption;
	}

	public void setPaymentOptionAddMoneyPayOption(PaymentOptionAddMoneyPayOption paymentOptionAddMoneyPayOption) {
		this.paymentOptionAddMoneyPayOption = paymentOptionAddMoneyPayOption;
	}

	public PaymentOptionMerchantLimitInfo getPaymentOptionMerchantLimitInfo() {
		return paymentOptionMerchantLimitInfo;
	}

	public void setPaymentOptionMerchantLimitInfo(PaymentOptionMerchantLimitInfo paymentOptionMerchantLimitInfo) {
		this.paymentOptionMerchantLimitInfo = paymentOptionMerchantLimitInfo;
	}
}
