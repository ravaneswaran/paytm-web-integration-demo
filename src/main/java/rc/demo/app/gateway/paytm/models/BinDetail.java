package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-bin-detail")
public class BinDetail {
	
	@XmlElement(name = "head")
	private BinDetailHead binDetailHead;
	
	@XmlElement(name = "body")
	private BinDetailBody binDetailBody;

	public BinDetailHead getBinDetailHead() {
		return binDetailHead;
	}

	public void setBinDetailHead(BinDetailHead binDetailHead) {
		this.binDetailHead = binDetailHead;
	}

	public BinDetailBody getBinDetailBody() {
		return binDetailBody;
	}

	public void setBinDetailBody(BinDetailBody binDetailBody) {
		this.binDetailBody = binDetailBody;
	}
}
