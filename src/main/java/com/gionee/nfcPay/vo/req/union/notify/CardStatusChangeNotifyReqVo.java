package com.gionee.nfcPay.vo.req.union.notify;

import java.util.List;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class CardStatusChangeNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 需要进行设备卡状态变更通知的设备卡PAN别名列表
	 */
	private List<CardStatusChangeNotifyVirtualCardItemVo> virtualCards;

	public List<CardStatusChangeNotifyVirtualCardItemVo> getVirtualCards() {
		return virtualCards;
	}

	public void setVirtualCards(
			List<CardStatusChangeNotifyVirtualCardItemVo> virtualCards) {
		this.virtualCards = virtualCards;
	}
	
	

}
