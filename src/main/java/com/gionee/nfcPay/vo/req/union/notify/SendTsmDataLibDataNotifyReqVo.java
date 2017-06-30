package com.gionee.nfcPay.vo.req.union.notify;

import java.util.List;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class SendTsmDataLibDataNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 设备卡PAN别名列表
	 * 单个设备上有可能存在多张设备卡
	 */
	private List<String> virtualCards;
	
	/**
	 * TSM控件执行数据
	 */
	private TsmLibDataVo tsmLibData;

	public List<String> getVirtualCards() {
		return virtualCards;
	}

	public void setVirtualCards(List<String> virtualCards) {
		this.virtualCards = virtualCards;
	}

	public TsmLibDataVo getTsmLibData() {
		return tsmLibData;
	}

	public void setTsmLibData(TsmLibDataVo tsmLibData) {
		this.tsmLibData = tsmLibData;
	}
	
	

}
