package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class CardProductItemVo extends BaseVo{
	
	/**
	 * 卡产品标识
	 */
	private String cardProductId;
	
	/**
	 * 卡产品版本标识
	 */
	private String version;
	
	/**
	 * 发卡行机构代码
	 */
	private String issuerId;
	
	/**
	 * 卡图片网址
	 */
	private String cardArt;
	
	/**
	 * 卡产品名称
	 */
	private String displayName;
	
	/**
	 * 卡属性 
	 */
	private String type;
	
	/**
	 * 卡面字体色彩模式
	 */
	private String frontColor;

	public String getCardProductId() {
		return cardProductId;
	}

	public void setCardProductId(String cardProductId) {
		this.cardProductId = cardProductId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrontColor() {
		return frontColor;
	}

	public void setFrontColor(String frontColor) {
		this.frontColor = frontColor;
	}
	
	

}
