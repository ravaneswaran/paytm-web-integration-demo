package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction-update")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransactionUpdate {

	/*
	 * {"paytm-transaction-update":{"head":{"responseTimestamp":"1571260458072",
	 * "version":"v1","signature":
	 * "sSyd35rT5QbThc7PSBpCsux3wgZOpokIiLTbTmyi3AOGL26PiM6/+A30nvqTRmfj+piui9rMp57hZ2OJvuKCsUvlnA552ewatUAlVjxF1bY="
	 * },"body":{"resultInfo":{"resultStatus":"S","resultCode":"0000","resultMsg":
	 * "Success"}}}}
	 */
	
	@XmlElement(name = "head")
	private PaytmTransactionUpdateHead paytmTransactionUpdateHead;
	
	@XmlElement(name = "body")
	private PaytmTransactionUpdateBody paytmTransactionUpdateBody;

	public PaytmTransactionUpdateHead getPaytmTransactionUpdateHead() {
		return paytmTransactionUpdateHead;
	}

	public void setPaytmTransactionUpdateHead(PaytmTransactionUpdateHead paytmTransactionUpdateHead) {
		this.paytmTransactionUpdateHead = paytmTransactionUpdateHead;
	}

	public PaytmTransactionUpdateBody getPaytmTransactionUpdateBody() {
		return paytmTransactionUpdateBody;
	}

	public void setPaytmTransactionUpdateBody(PaytmTransactionUpdateBody paytmTransactionUpdateBody) {
		this.paytmTransactionUpdateBody = paytmTransactionUpdateBody;
	}
}
