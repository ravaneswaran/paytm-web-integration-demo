package rc.demo.app.gateway.service;

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
}
