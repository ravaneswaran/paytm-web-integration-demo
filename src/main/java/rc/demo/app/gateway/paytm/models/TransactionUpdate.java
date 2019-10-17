package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction-update")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionUpdate {

	/*
	 * {"paytm-transaction-update":{"head":{"responseTimestamp":"1571260458072",
	 * "version":"v1","signature":
	 * "sSyd35rT5QbThc7PSBpCsux3wgZOpokIiLTbTmyi3AOGL26PiM6/+A30nvqTRmfj+piui9rMp57hZ2OJvuKCsUvlnA552ewatUAlVjxF1bY="
	 * },"body":{"resultInfo":{"resultStatus":"S","resultCode":"0000","resultMsg":
	 * "Success"}}}}
	 */
	
	@XmlElement(name = "head")
	private TransactionUpdateHead paytmTransactionUpdateHead;
	
	@XmlElement(name = "body")
	private TransactionUpdateBody paytmTransactionUpdateBody;

	public TransactionUpdateHead getPaytmTransactionUpdateHead() {
		return paytmTransactionUpdateHead;
	}

	public void setPaytmTransactionUpdateHead(TransactionUpdateHead paytmTransactionUpdateHead) {
		this.paytmTransactionUpdateHead = paytmTransactionUpdateHead;
	}

	public TransactionUpdateBody getPaytmTransactionUpdateBody() {
		return paytmTransactionUpdateBody;
	}

	public void setPaytmTransactionUpdateBody(TransactionUpdateBody paytmTransactionUpdateBody) {
		this.paytmTransactionUpdateBody = paytmTransactionUpdateBody;
	}
}
