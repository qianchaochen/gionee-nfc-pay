package com.gionee.nfcPay.vo.req.union.notify;

import java.util.List;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class BatchCardProductInfoSynNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 卡产品信息列表
	 */
	private List<CardProductItemVo> cardProductList;

	public List<CardProductItemVo> getCardProductList() {
		return cardProductList;
	}

	public void setCardProductList(List<CardProductItemVo> cardProductList) {
		this.cardProductList = cardProductList;
	}
	
}
