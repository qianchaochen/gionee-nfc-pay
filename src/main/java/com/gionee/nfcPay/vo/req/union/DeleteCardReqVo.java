package com.gionee.nfcPay.vo.req.union;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class DeleteCardReqVo extends BaseUnionReqVo{
	
	/**
	 * 取值：DELETED
	 */
	private String status;
	
	/**
	 * 原因
	 */
	private String reason;
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}
	

}
