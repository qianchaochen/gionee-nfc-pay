package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class CardProductInfoChangeNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 卡产品标识
	 */
	private String cardProductId;
	
	/**
	 * 发卡行机构代码
	 */
	private String issuerId;
	
	/**
	 * 银行信息的版本号
	 */
	private String version;

	public String getCardProductId() {
		return cardProductId;
	}

	public void setCardProductId(String cardProductId) {
		this.cardProductId = cardProductId;
	}

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


}
