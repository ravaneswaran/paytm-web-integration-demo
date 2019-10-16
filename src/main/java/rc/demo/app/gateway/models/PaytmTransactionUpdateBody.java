package rc.demo.app.gateway.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaytmTransactionUpdateBody {
	
	/*{"resultInfo":{"resultStatus":"S","resultCode":"0000","resultMsg":
	 * "Success"}}*/
	
	@XmlElement(name = "resultInfo")
	private PaytmTransactionUpdateResultInfo paytmTransactionUpdateResultInfo;

}
