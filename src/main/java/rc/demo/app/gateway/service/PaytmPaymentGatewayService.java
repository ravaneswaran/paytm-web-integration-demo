package rc.demo.app.gateway.service;

public class PaytmPaymentGatewayService {

	public static PaytmInitiateTransactionService getInitiateTransactionService(String userId, String orderId,
			long amount, String currency) {
		return new PaytmInitiateTransactionService(userId, orderId, amount, currency);
	}

	public static PaytmTransactionStatusService getTransactionStatusService(String orderId) {
		return new PaytmTransactionStatusService(orderId);
	}

	public static PaytmRefundService getRefundService(String orderId, String paytmTransactionId, String refundId,
			long amountToRefund) {
		return new PaytmRefundService(orderId, paytmTransactionId, refundId, amountToRefund);
	}
	
	public static PaytmRefundStatusService getRefundStatusService(String orderId, String refundId) {
		return new PaytmRefundStatusService(orderId, refundId);
	}
}
