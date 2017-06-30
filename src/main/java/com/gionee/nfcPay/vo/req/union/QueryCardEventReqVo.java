/**
 * 
 */
package com.gionee.nfcPay.vo.req.union;

/**
 * @author zhanggq
 *
 *         2017年6月21日
 */
public class QueryCardEventReqVo extends BaseUnionReqVo {
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	/**
	 * 时间戳
	 */
	private String submitTime;

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

}
