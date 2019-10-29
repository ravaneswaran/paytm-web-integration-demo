package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-nb-payment-channel")
public class NetBankingPaymentChannel {

	@XmlElement(name = "head")
	private NetBankingPaymentChannelHead netBankingPaymentChannelHead;

	@XmlElement(name = "body")
	private NetBankingPaymentChannelBody netBankingPaymentChannelBody;

	public NetBankingPaymentChannelHead getNetBankingPaymentChannelHead() {
		return netBankingPaymentChannelHead;
	}

	public void setNetBankingPaymentChannelHead(NetBankingPaymentChannelHead netBankingPaymentChannelHead) {
		this.netBankingPaymentChannelHead = netBankingPaymentChannelHead;
	}

	public NetBankingPaymentChannelBody getNetBankingPaymentChannelBody() {
		return netBankingPaymentChannelBody;
	}

	public void setNetBankingPaymentChannelBody(NetBankingPaymentChannelBody netBankingPaymentChannelBody) {
		this.netBankingPaymentChannelBody = netBankingPaymentChannelBody;
	}

}
