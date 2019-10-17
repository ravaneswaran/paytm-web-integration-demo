package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionUpdateBody {
	
	/*{"resultInfo":{"resultStatus":"S","resultCode":"0000","resultMsg":
	 * "Success"}}*/
	
	@XmlElement(name = "resultInfo")
	private TransactionUpdateResultInfo paytmTransactionUpdateResultInfo;

}
