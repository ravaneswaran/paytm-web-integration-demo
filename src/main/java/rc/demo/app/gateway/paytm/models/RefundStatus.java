package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-refund-status")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundStatus extends Refund{

	/*
	 * {"paytm-refund-status":{"head":{"clientId":"C11","responseTimestamp":
	 * "1571250168090","signature":
	 * "kMaetRgWihJCjBJBPbnP39w1yZAoSU0YkLVeVsoWX7GsWOD2Lj7aumYDJgAcanbGLiqnSKRAt91CKoNpCm2lt8FS6+MQogV+jcJly/XuvWI="
	 * ,"version":"v1"},"body":{"orderId":"222aabd2-2309-4f8a-bc32-d0e375e11503",
	 * "mid":"MqSnHc74327968593861","refId":"REFUND_1571250205531_ID","resultInfo":{
	 * "resultStatus":"TXN_FAILURE","resultCode":"631","resultMsg":""}}}}
	 */

}
