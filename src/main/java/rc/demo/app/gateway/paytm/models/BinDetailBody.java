package rc.demo.app.gateway.paytm.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class BinDetailBody {

	@XmlElement(name = "resultInfo")
	private BinDetailResultInfo binDetailResultInfo;
	
	private boolean isEmiAvailable;
	
	private BinDetailBinDetail binDetailBinDetail;
	
	private List<BinDetailAuthMode> binDetailAuthModes;
	
	private BinDetailHasLowSuccessRate binDetailHasLowSuccessRate;
	
	private String iconUrl;
	
	private String errorMessage;
	
	private boolean hybridDisabled;

	public BinDetailResultInfo getBinDetailResultInfo() {
		return binDetailResultInfo;
	}

	public void setBinDetailResultInfo(BinDetailResultInfo binDetailResultInfo) {
		this.binDetailResultInfo = binDetailResultInfo;
	}

	public boolean isEmiAvailable() {
		return isEmiAvailable;
	}

	public void setEmiAvailable(boolean isEmiAvailable) {
		this.isEmiAvailable = isEmiAvailable;
	}

	public BinDetailBinDetail getBinDetailBinDetail() {
		return binDetailBinDetail;
	}

	public void setBinDetailBinDetail(BinDetailBinDetail binDetailBinDetail) {
		this.binDetailBinDetail = binDetailBinDetail;
	}

	public List<BinDetailAuthMode> getBinDetailAuthModes() {
		return binDetailAuthModes;
	}

	public void setBinDetailAuthModes(List<BinDetailAuthMode> binDetailAuthModes) {
		this.binDetailAuthModes = binDetailAuthModes;
	}

	public BinDetailHasLowSuccessRate getBinDetailHasLowSuccessRate() {
		return binDetailHasLowSuccessRate;
	}

	public void setBinDetailHasLowSuccessRate(BinDetailHasLowSuccessRate binDetailHasLowSuccessRate) {
		this.binDetailHasLowSuccessRate = binDetailHasLowSuccessRate;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isHybridDisabled() {
		return hybridDisabled;
	}

	public void setHybridDisabled(boolean hybridDisabled) {
		this.hybridDisabled = hybridDisabled;
	}

}
