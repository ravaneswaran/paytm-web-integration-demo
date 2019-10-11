package rc.demo.razorpay.service.local;

import rc.demo.razorpay.dao.OrderProductJoinDAO;
import rc.demo.razorpay.models.OrderProductJoin;

import java.util.List;

public class OrderProductJoinLocalService {

    private static final OrderProductJoinDAO ORDER_PRODUCT_JOIN_DAO = new OrderProductJoinDAO();

    public static final OrderProductJoin fetchById(String orderProductJoinId){
        return ORDER_PRODUCT_JOIN_DAO.findById(orderProductJoinId);
    }

    public static final List<OrderProductJoin> listOrderProductJoinsByOrderId(String orderId){
        return ORDER_PRODUCT_JOIN_DAO.findByOrderId(orderId);
    }

    public static final void register(OrderProductJoin orderProductJoin){
        ORDER_PRODUCT_JOIN_DAO.save(orderProductJoin);
    }

    public static void delete(OrderProductJoin orderProductJoin) {
        ORDER_PRODUCT_JOIN_DAO.delete(orderProductJoin);
    }
}
