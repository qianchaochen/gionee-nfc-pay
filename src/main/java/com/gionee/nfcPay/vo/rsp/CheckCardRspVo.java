package com.gionee.nfcPay.vo.rsp;


/**
 * @author dingyw
 *
 * 2017年6月13日
 */
public class CheckCardRspVo extends BaseUnionRspVo{
	/**
	 * 银行的唯一编码
	 */
	private String issuerId;

	/**
	 * 银行卡类型
	 * 借记卡：DEBIT
	      贷记卡：CREDIT
	 */
	private String cardType;
	
	/**
	 * 发卡行名称
	 */
	private String name;
	
	/**
	 * 发卡行信息描述
	 */
	private String description;
	
	/**
	 * 发卡行logo
	 */
	private String logo;

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
