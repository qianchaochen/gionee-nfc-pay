package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class CardStatusChangeNotifyVirtualCardItemVo extends BaseVo{
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	
	/**
	 * 变更后的状态
	 */
	private String status;

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
