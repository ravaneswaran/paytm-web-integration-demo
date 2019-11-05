package rc.demo.app.gateway.paytm.services;

public class PaytmPaymentGatewayService {

	public static InitiateTransactionService getInitiateTransactionService(String userId, String orderId, long amount,
			String currency) {
		return new InitiateTransactionService(userId, orderId, amount, currency);
	}

	public static TransactionStatusService getTransactionStatusService(String orderId) {
		return new TransactionStatusService(orderId);
	}

	public static RefundService getRefundService(String orderId, String paytmTransactionId, String refundId,
			long amountToRefund) {
		return new RefundService(orderId, paytmTransactionId, refundId, amountToRefund);
	}

	public static RefundStatusService getRefundStatusService(String orderId, String refundId) {
		return new RefundStatusService(orderId, refundId);
	}

	public static TransactionUpdateService getTransactionUpdateService(String orderId, String customerId,
			String transactionToken, String currency, long amount) {
		return new TransactionUpdateService(orderId, customerId, transactionToken, currency, amount);
	}

	public static ProcessTransactionService getProcessTransactionService(String orderId, String transactionToken,
			String paymentMode, String authMode, String cardInfo) {
		return new ProcessTransactionService(orderId, transactionToken, paymentMode, authMode, cardInfo);
	}

	public static PaymentStatusService getPaymentStatusService(String orderId) {
		return new PaymentStatusService(orderId);
	}

	public static InitiateSubscriptionService getInitiateSubscriptionService(String customerId, String orderId,
			String transactionAmount, String currency, String subscriptionMaxAmount, String subscriptionPaymentMode,
			String subscriptionAmountType, int subscriptionFrequency, String subscriptionFrequencyUnit,
			long subscriptionStartDate, long subscriptionExpiryDate, int subscriptionGraceDays,
			int subscriptionEnableRetry, int subscriptionRetryCount) {
		return new InitiateSubscriptionService(customerId, orderId, transactionAmount, currency, subscriptionMaxAmount,
				subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit,
				subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry,
				subscriptionRetryCount);
	}

	public static PaymentOptionService getPaymentOptionService(String orderId, String transactionToken) {
		return new PaymentOptionService(orderId, transactionToken);
	}

	public static BinDetailService getBinDetailService(String orderId, String transactionToken, String bin) {
		return new BinDetailService(orderId, transactionToken, bin);
	}

	public static NetBankingPaymentChannelService getNetBankingPaymentChannelService(String orderId,
			String transactionToken) {
		return new NetBankingPaymentChannelService(orderId, transactionToken);
	}

	public static FetchEMIDetailsService getFetchEMIDetailsService(String orderId, String transactionToken,
			String[] channelCodes) {
		return new FetchEMIDetailsService(orderId, transactionToken, channelCodes);
	}

	public static SendOTPService getSendOTPService(String orderId, String transactionToken, String mobileNumber) {
		return new SendOTPService(orderId, transactionToken, mobileNumber);
	}

	public static ValidateOTPService getValidateOTPService(String orderId, String transactionToken, String otp) {
		return new ValidateOTPService(orderId, transactionToken, otp);
	}

	public static BalanceInfoService getBalanceInfoService(String orderId, String transactionToken) {
		return new BalanceInfoService(orderId, transactionToken);
	}

	public static DirectBankRequestService getDirectBankRequestService(String orderId, String transactionToken,
			String otp) {
		return new DirectBankRequestService(orderId, transactionToken, otp);
	}

}