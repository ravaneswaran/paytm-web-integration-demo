package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-process-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessTransaction {
	
	@XmlElement(name = "head")
	private ProcessTransactionHead paytmProcessTransactionHead;
	
	@XmlElement(name = "body")
	private ProcessTransactionBody paytmProcessTransactionBody;

	public ProcessTransactionHead getPaytmProcessTransactionHead() {
		return paytmProcessTransactionHead;
	}

	public void setPaytmProcessTransactionHead(ProcessTransactionHead paytmProcessTransactionHead) {
		this.paytmProcessTransactionHead = paytmProcessTransactionHead;
	}

	public ProcessTransactionBody getPaytmProcessTransactionBody() {
		return paytmProcessTransactionBody;
	}

	public void setPaytmProcessTransactionBody(ProcessTransactionBody paytmProcessTransactionBody) {
		this.paytmProcessTransactionBody = paytmProcessTransactionBody;
	}

}
