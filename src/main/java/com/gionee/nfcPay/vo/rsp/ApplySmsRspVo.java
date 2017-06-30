package com.gionee.nfcPay.vo.rsp;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class ApplySmsRspVo extends BaseUnionRspVo{
	
	/**
	 * 表示otp值的过期时间
	 */
	private String expirationDate;

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
