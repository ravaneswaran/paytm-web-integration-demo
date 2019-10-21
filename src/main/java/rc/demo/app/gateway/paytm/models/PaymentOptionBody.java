package rc.demo.app.gateway.paytm.models;

public class PaymentOptionBody {

	private boolean walletOnly;

	private boolean zeroCostEmi;

	private boolean pcfEnabled;

	private boolean nativeJsonRequestSupported;

	private boolean activeMerchant;

	private boolean onTheFlyKYCRequired;

	private String paymentFlow;

	private PaymentOptionResultInfo paymentOptionResultInfo;

	private PaymentOptionMerchantPayOption paymentOptionMerchantPayOption;

	private PaymentOptionAddMoneyPayOption paymentOptionAddMoneyPayOption;

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
