/**
 * 
 */
package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author zhanggq
 *
 *         2017年6月29日
 */
public class CardEnrollClientRspVo extends BaseMsgVo{
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
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	/**
	 * 设备卡卡号
	 */
	private String virtualCardNum;
	/**
	 * 时间戳
	 */
	private String submitTime;
	/**
	 * 卡图片URL
	 */
	private String card_logo_url;

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

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getVirtualCardNum() {
		return virtualCardNum;
	}

	public void setVirtualCardNum(String virtualCardNum) {
		this.virtualCardNum = virtualCardNum;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getCard_logo_url() {
		return card_logo_url;
	}

	public void setCard_logo_url(String card_logo_url) {
		this.card_logo_url = card_logo_url;
	}

}
