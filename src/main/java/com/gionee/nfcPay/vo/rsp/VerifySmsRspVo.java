package com.gionee.nfcPay.vo.rsp;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class VerifySmsRspVo extends BaseUnionRspVo{
	
	/**
	 * 银行验证OTP通过，取值ACCEPTED
	 */
	private String verifyResult;

	public String getVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	

}
