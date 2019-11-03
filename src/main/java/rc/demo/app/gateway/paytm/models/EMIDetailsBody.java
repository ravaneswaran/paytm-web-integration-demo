package rc.demo.app.gateway.paytm.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class EMIDetailsBody {
	
	@XmlElement(name = "resultInfo")
	private EMIDetailsResultInfo eMIDetailsResultInfo;
	
	@XmlElement(name = "extraParamsMap")
	private EMIDetailsExtraParamMap eMIDetailsExtraParamMap;
	
	@XmlElement(name = "emiDetail")
	private EMIDetail eMIDetail;

	public EMIDetailsResultInfo geteMIDetailsResultInfo() {
		return eMIDetailsResultInfo;
	}

	public void seteMIDetailsResultInfo(EMIDetailsResultInfo eMIDetailsResultInfo) {
		this.eMIDetailsResultInfo = eMIDetailsResultInfo;
	}

	public EMIDetailsExtraParamMap geteMIDetailsExtraParamMap() {
		return eMIDetailsExtraParamMap;
	}

	public void seteMIDetailsExtraParamMap(EMIDetailsExtraParamMap eMIDetailsExtraParamMap) {
		this.eMIDetailsExtraParamMap = eMIDetailsExtraParamMap;
	}

	public EMIDetail geteMIDetail() {
		return eMIDetail;
	}

	public void seteMIDetail(EMIDetail eMIDetail) {
		this.eMIDetail = eMIDetail;
	}
}
