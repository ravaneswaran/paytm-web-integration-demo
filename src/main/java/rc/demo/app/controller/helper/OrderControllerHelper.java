package rc.demo.app.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rc.demo.app.controller.PaytmController;
import rc.demo.app.local.service.OrderLocalService;
import rc.demo.app.local.service.OrderProductJoinLocalService;
import rc.demo.app.models.Order;
import rc.demo.app.models.OrderProductJoin;

public class OrderControllerHelper extends PaytmController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		throw new NotImplementedException("'doprocess()' method should be overridden...");
	}

	protected int deleteOrder(String orderId) {
		List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(orderId);

		if (null != orderProductJoins && !orderProductJoins.isEmpty()) {
			for (OrderProductJoin orderProductJoin : orderProductJoins) {
				OrderProductJoinLocalService.delete(orderProductJoin);
			}
		}

		Order order = OrderLocalService.fetchOrderById(orderId);
		OrderLocalService.purge(order);

		return 0;
	}

}
