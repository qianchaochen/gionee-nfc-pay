package com.gionee.nfcPay.vo.req.union;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class ApplySmsReqVo extends BaseUnionReqVo{

	/**
	 * OTP激活方式
	 * OTPSMS
	 */
	private String otpMethod;
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	

	public String getOtpMethod() {
		return otpMethod;
	}

	public void setOtpMethod(String otpMethod) {
		this.otpMethod = otpMethod;
	}

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}
	

}
