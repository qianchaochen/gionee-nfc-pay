package com.gionee.nfcPay.vo.req.union;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class CipheredCardInfoVo extends BaseVo{
	
	/**
	 * 实体卡信息
	 */
	private String cardInfo;
	
	/**
	 * 借记卡支付密码
	 */
	private String pin;
	
	/**
	 * 贷记卡cvn2
	 */
	private String cvn2;

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCvn2() {
		return cvn2;
	}

	public void setCvn2(String cvn2) {
		this.cvn2 = cvn2;
	}
	

}
