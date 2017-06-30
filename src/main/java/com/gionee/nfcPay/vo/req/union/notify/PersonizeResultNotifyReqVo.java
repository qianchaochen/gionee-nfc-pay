package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class PersonizeResultNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	
	/**
	 * 个人化结果
	 */
	private String status;
	
	/**
	 * 虚拟卡应用AID
	 */
	private String aid;

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

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	
	

}
