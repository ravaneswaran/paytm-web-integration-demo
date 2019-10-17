package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionBody {
	
	@XmlElement(name = "resultInfo")
	private SubscriptionResultInfo subscriptionResultInfo;
	
	@XmlElement(name = "extraParamsMap")
	private SubscriptionExtraParamsMap subscriptionExtraParamsMap;

	public SubscriptionResultInfo getSubscriptionResultInfo() {
		return subscriptionResultInfo;
	}

	public void setSubscriptionResultInfo(SubscriptionResultInfo subscriptionResultInfo) {
		this.subscriptionResultInfo = subscriptionResultInfo;
	}

	public SubscriptionExtraParamsMap getSubscriptionExtraParamsMap() {
		return subscriptionExtraParamsMap;
	}

	public void setSubscriptionExtraParamsMap(SubscriptionExtraParamsMap subscriptionExtraParamsMap) {
		this.subscriptionExtraParamsMap = subscriptionExtraParamsMap;
	}
}
