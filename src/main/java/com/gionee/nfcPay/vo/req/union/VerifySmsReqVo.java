package com.gionee.nfcPay.vo.req.union;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class VerifySmsReqVo extends BaseUnionReqVo{
	
	/**
	 * 用户在手机客户端输入的OTP值
	 */
	private String otpValue;
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;

	public String getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(String otpValue) {
		this.otpValue = otpValue;
	}

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}
	

}
