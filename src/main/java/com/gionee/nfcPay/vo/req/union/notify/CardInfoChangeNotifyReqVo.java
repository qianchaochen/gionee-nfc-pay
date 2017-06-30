package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class CardInfoChangeNotifyReqVo extends BaseVo{
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	
	/**
	 * 实体卡PAN别名
	 */
	private String cardReferenceId;

	/**
	 * 卡产品标识
	 */
	private String cardProductId;
	
	/**
	 * 卡号的后四位数字
	 */
	private String lastDigits;
	
	/**
	 * 任务流水号
	 */
	private String taskId;

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getCardReferenceId() {
		return cardReferenceId;
	}

	public void setCardReferenceId(String cardReferenceId) {
		this.cardReferenceId = cardReferenceId;
	}

	public String getCardProductId() {
		return cardProductId;
	}

	public void setCardProductId(String cardProductId) {
		this.cardProductId = cardProductId;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}
