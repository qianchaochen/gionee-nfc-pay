package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class CardMetadataVo extends BaseVo{
	
	/**
	 * 实体卡PAN的别名
	 */
	private String cardReferenceId;
	
	/**
	 * 银行卡产品ID
	 */
	private String cardProductId;
	
	/**
	 * 卡号的后四位数字
	 */
	private String lastDigits;

	public String getCardReferenceId() {
		return cardReferenceId;
	}

	public void setCardReferenceId(String cardReferenceId) {
		this.cardReferenceId = cardReferenceId;
	}

	public String getCardProductId() {
		return cardProductId;
	}

	public void setCardProductId(String cardProductId) {
		this.cardProductId = cardProductId;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}
	

}
