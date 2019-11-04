package rc.demo.app.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rc.demo.app.RequestParameter;
import rc.demo.app.SessionAttributes;
import rc.demo.app.controller.helper.OrderControllerHelper;
import rc.demo.app.gateway.paytm.models.BalanceInfo;
import rc.demo.app.gateway.paytm.models.FetchEMIDetails;
import rc.demo.app.gateway.paytm.models.SendOTP;
import rc.demo.app.gateway.paytm.models.Transaction;
import rc.demo.app.gateway.paytm.models.ValidateOTP;
import rc.demo.app.gateway.paytm.services.PaytmPaymentGatewayService;
import rc.demo.app.local.service.OrderLocalService;
import rc.demo.app.local.service.OrderProductJoinLocalService;
import rc.demo.app.models.Order;
import rc.demo.app.models.OrderProductJoin;
import rc.demo.app.models.Product;
import rc.demo.app.models.User;

public class OrderController extends OrderControllerHelper {

	private static final long serialVersionUID = 1L;

	public static final String NEW = "new";
	public static final String DETAILS = "details";
	public static final String LISTING = "listing";
	public static final String DELETE = "delete";

	private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String command = request.getParameter(RequestParameter.COMMAND);
		switch (command) {
		case NEW:
			newOrder(request, response);
			break;
		case LISTING:
			listOrders(request, response);
			break;
		case DELETE:
			deleteOrder(request, response);
			break;
		case DETAILS:
			orderDetails(request, response);
			break;
		}
	}

	protected void newOrder(HttpServletRequest request, HttpServletResponse response) {
		String orderId = request.getParameter("order-id");
		List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(orderId);

		long totalPrice = 0l;
		long gst = 0l;
		long amount = 0l;
		if (null != orderProductJoins && !orderProductJoins.isEmpty()) {
			for (OrderProductJoin orderProductJoin : orderProductJoins) {
				Product product = orderProductJoin.getProduct();
				totalPrice += product.getPrice();
				gst += (product.getPrice() * 5) / 100;
			}
		}
		amount = totalPrice + (2 * gst);

		HttpSession httpSession = request.getSession(false);

		if (null != httpSession) {
			User sessionUser = (User) httpSession.getAttribute(SessionAttributes.SESSION_USER);

			Transaction paytmTransaction = PaytmPaymentGatewayService
					.getInitiateTransactionService(sessionUser.getId(), orderId, amount, "INR").serve();

			if (null != paytmTransaction) {

				PaytmPaymentGatewayService.getTransactionStatusService(orderId).serve();

				String randomRefundId = String.format("REFUND_%s_ID", new Date().getTime());
				PaytmPaymentGatewayService
						.getRefundService(orderId, paytmTransaction.getBody().getTxnToken(), randomRefundId, 12345l)
						.serve();

				PaytmPaymentGatewayService.getRefundStatusService(orderId, randomRefundId).serve();

				PaytmPaymentGatewayService.getTransactionUpdateService(orderId, sessionUser.getId(),
						paytmTransaction.getBody().getTxnToken(), "INR", 2).serve();

				PaytmPaymentGatewayService.getProcessTransactionService(orderId,
						paytmTransaction.getBody().getTxnToken(), "CREDIT_CARD", "OTP", "|5242165000203040|983|122022")
						.serve();

				PaytmPaymentGatewayService.getPaymentStatusService(orderId).serve();

				long now = System.currentTimeMillis();
				long thirtyDays = now + (30 * (1440 * 60 * 1000));
				PaytmPaymentGatewayService.getInitiateSubscriptionService(sessionUser.getId(), orderId, "100.00", "INR",
						"200.00", "PPI", "VARIABLE", 1, "MONTHLY", now, thirtyDays, 3, 1, 3).serve();

				PaytmPaymentGatewayService.getPaymentOptionService(orderId, paytmTransaction.getBody().getTxnToken())
						.serve();

				PaytmPaymentGatewayService
						.getBinDetailService(orderId, paytmTransaction.getBody().getTxnToken(), "123456").serve();

				PaytmPaymentGatewayService
						.getNetBankingPaymentChannelService(orderId, paytmTransaction.getBody().getTxnToken()).serve();

				String[] channelCodes = { "HDFC", "ICICI" };
				PaytmPaymentGatewayService
						.getFetchEMIDetailsService(orderId, paytmTransaction.getBody().getTxnToken(), channelCodes)
						.serve();

				String mobileNumber = "7777777777";
				PaytmPaymentGatewayService
						.getSendOTPService(orderId, paytmTransaction.getBody().getTxnToken(), mobileNumber).serve();

				String otp = "987654";
				PaytmPaymentGatewayService
						.getValidateOTPService(orderId, paytmTransaction.getBody().getTxnToken(), otp).serve();
				
				BalanceInfo balanceInfo = PaytmPaymentGatewayService.getBalanceInfoService(orderId, paytmTransaction.getBody().getTxnToken()).serve();
				

				System.out.println("balanceInfo -------------------->>>>>>> " + balanceInfo);

				httpSession.setAttribute(SessionAttributes.PAYTM_TRANSACTION, paytmTransaction);
				try {
					response.getWriter().print("0");
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
					toErrorPage500(request, response);
					return;
				}
			} else {
				try {
					response.getWriter().print("Unable to contact payment gateway !!!");
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
					toErrorPage500(request, response);
					return;
				}
			}
		} else {
			try {
				response.sendRedirect("../pages/login.jsp");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				toErrorPage500(request, response);
				return;
			}
		}
	}

	protected void listOrders(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter(RequestParameter.USER_ID);
		Order currentOrder = new Order();

		List<Order> previousOrders = OrderLocalService.listOrdersByUserId(userId);
		HttpSession httpSession = request.getSession(false);

		httpSession.setAttribute(SessionAttributes.SESSION_ORDER, currentOrder);
		httpSession.setAttribute(SessionAttributes.PREVIOUS_ORDERS, previousOrders);

		try {
			response.sendRedirect("../pages/order-listing.jsp");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			toErrorPage500(request, response);
			return;
		}
	}

	protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			User sessionUser = (User) httpSession.getAttribute(SessionAttributes.SESSION_USER);
			if (null != sessionUser) {
				String orderId = request.getParameter(RequestParameter.ORDER_ID);
				int result = this.deleteOrder(orderId);
				if (0 == result) {
					try {
						response.getWriter().print("0");
					} catch (IOException e) {
						LOGGER.log(Level.SEVERE, e.getMessage(), e);
						toErrorPage500(request, response);
						return;
					}
				} else {
					try {
						response.getWriter().print(String.format("Unable to delete the order('%s')", orderId));
					} catch (IOException e) {
						LOGGER.log(Level.SEVERE, e.getMessage(), e);
						toErrorPage500(request, response);
						return;
					}
				}
			} else {
				try {
					response.sendRedirect("../pages/login.jsp");
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
					toErrorPage500(request, response);
					return;
				}
			}
		} else {
			try {
				response.sendRedirect("../pages/login.jsp");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				toErrorPage500(request, response);
				return;
			}
		}
	}

	protected void orderDetails(HttpServletRequest request, HttpServletResponse response) {

		HttpSession httpSession = request.getSession(false);

		if (null != httpSession) {
			String orderId = request.getParameter(RequestParameter.ORDER_ID);
			Order order = OrderLocalService.fetchOrderById(orderId);

			httpSession.setAttribute(SessionAttributes.SESSION_ORDER, order);

			try {
				response.sendRedirect("../pages/order-details.jsp");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				toErrorPage500(request, response);
				return;
			}
		} else {
			try {
				response.sendRedirect("../pages/login.jsp");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				toErrorPage500(request, response);
				return;
			}
		}
	}
}
