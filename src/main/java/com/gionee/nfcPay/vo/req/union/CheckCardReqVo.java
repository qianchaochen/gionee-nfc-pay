package com.gionee.nfcPay.vo.req.union;


/**
 * @author dingyw
 *
 * 2017年6月13日
 */
public class CheckCardReqVo extends BaseUnionReqVo{
	
	/**
	 * 加密的实体卡号
	 */
	private String cipheredPan;

	public String getCipheredPan() {
		return cipheredPan;
	}

	public void setCipheredPan(String cipheredPan) {
		this.cipheredPan = cipheredPan;
	}
	
	

}
