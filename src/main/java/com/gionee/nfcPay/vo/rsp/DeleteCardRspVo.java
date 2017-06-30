package com.gionee.nfcPay.vo.rsp;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class DeleteCardRspVo extends BaseUnionRspVo{
	
	/**
	 * 应答码
	 */
	private String resultCode;
	
	/**
	 * 应答消息
	 */
	private String resultMessage;
	
	/**
	 * 时间戳
	 */
	private String submitTime;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	
}
