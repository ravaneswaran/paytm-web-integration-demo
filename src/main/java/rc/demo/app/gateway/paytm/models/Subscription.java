package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-subscription")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscription {
	
	/*
	 * {"paytm-subscription":{"head":{"requestId":null,"responseTimestamp":
	 * "1571328724670","version":"v1"},"body":{"resultInfo":{"resultStatus":"F",
	 * "resultCode":"4001","resultMsg":"Invalid Frequency Unit"},"extraParamsMap":
	 * null}}}
	 */
	
	@XmlElement(name = "head")
	private SubscriptionHead subscriptionHead;
	
	@XmlElement(name = "body")
	private SubscriptionBody subscriptionBody;

	public SubscriptionHead getSubscriptionHead() {
		return subscriptionHead;
	}

	public void setSubscriptionHead(SubscriptionHead subscriptionHead) {
		this.subscriptionHead = subscriptionHead;
	}

	public SubscriptionBody getSubscriptionBody() {
		return subscriptionBody;
	}

	public void setSubscriptionBody(SubscriptionBody subscriptionBody) {
		this.subscriptionBody = subscriptionBody;
	}
	
	

}
