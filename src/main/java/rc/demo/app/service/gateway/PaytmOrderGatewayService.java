package rc.demo.app.service.gateway;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import rc.demo.app.models.OrderTransaction;

public class PaytmOrderGatewayService {
	
	public static OrderTransaction createNewOrder(long amount, String currency, int receiptNumber,
			int paymentCapture) throws IOException, JAXBException {
		return null;
	}
	
	public static OrderTransaction fetchOrderTransaction(String orderId) {
		return null;
	}
}
