/**
 * 
 */
package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author zhanggq
 *
 *         2017年6月24日
 */
public class QueryCardListItemVo extends BaseMsgVo {
	/**
	 * 应用ID
	 */
	private String aid;
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	/**
	 * 卡号的后四位
	 */
	private String lastDigits;

	/**
	 * 卡图片网址
	 */
	private String cardArt;

	/**
	 * 卡产品名称
	 */
	private String displayName;

	/**
	 * 客服电话
	 */
	private String tel;

	/**
	 * 卡类型，bus公交卡， bank银联卡
	 */
	private String type;

	/**
	 * 显示的卡号
	 */
	private String card_no;
	
	/**
	 * 银行官网
	 */
	private String website;
	
	/**
	 * 卡详情图片url
	 */
	private String cardDetailArt;
	
	/**
	 * 安全载体CPLC
	 */
	private String xTsmCplc;
	

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}

	public String getCardArt() {
		return cardArt;
	}

	public void setCardArt(String cardArt) {
		this.cardArt = cardArt;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCardDetailArt() {
		return cardDetailArt;
	}

	public void setCardDetailArt(String cardDetailArt) {
		this.cardDetailArt = cardDetailArt;
	}

	public String getxTsmCplc() {
		return xTsmCplc;
	}

	public void setxTsmCplc(String xTsmCplc) {
		this.xTsmCplc = xTsmCplc;
	}
}
