package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class NetBankingPaymentChannelBody {

	@XmlElement(name = "resultInfo")
	private NetBankingPaymentChannelBodyResultInfo netBankingPaymentChannelBodyResultInfo;

	@XmlElement(name = "extraParamsMap")
	private NetBankingPaymentChannelBodyExtraParamsMap netBankingPaymentChannelBodyExtraParamsMap;

	@XmlElement(name = "nbPayOption")
	private NetBankingPaymentChannelPayOption netBankingPaymentChannelPayOption;

	public NetBankingPaymentChannelBodyResultInfo getNetBankingPaymentChannelBodyResultInfo() {
		return netBankingPaymentChannelBodyResultInfo;
	}

	public void setNetBankingPaymentChannelBodyResultInfo(
			NetBankingPaymentChannelBodyResultInfo netBankingPaymentChannelBodyResultInfo) {
		this.netBankingPaymentChannelBodyResultInfo = netBankingPaymentChannelBodyResultInfo;
	}

	public NetBankingPaymentChannelBodyExtraParamsMap getNetBankingPaymentChannelBodyExtraParamsMap() {
		return netBankingPaymentChannelBodyExtraParamsMap;
	}

	public void setNetBankingPaymentChannelBodyExtraParamsMap(
			NetBankingPaymentChannelBodyExtraParamsMap netBankingPaymentChannelBodyExtraParamsMap) {
		this.netBankingPaymentChannelBodyExtraParamsMap = netBankingPaymentChannelBodyExtraParamsMap;
	}

	public NetBankingPaymentChannelPayOption getNetBankingPaymentChannelPayOption() {
		return netBankingPaymentChannelPayOption;
	}

	public void setNetBankingPaymentChannelPayOption(
			NetBankingPaymentChannelPayOption netBankingPaymentChannelPayOption) {
		this.netBankingPaymentChannelPayOption = netBankingPaymentChannelPayOption;
	}

}
