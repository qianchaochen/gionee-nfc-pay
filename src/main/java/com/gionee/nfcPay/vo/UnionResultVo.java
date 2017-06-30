/**
 * 
 */
package com.gionee.nfcPay.vo;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author zhanggq
 *
 * 2017年6月23日
 */
public class UnionResultVo extends BaseMsgVo{
	
	/**
	 * 请求银联response body
	 */
	private String result;
	/**
	 * 交易接收方交易时间
	 */
	private String transTimeDestination;
	
	/**
	 * 交易接收方流水号
	 */
	private String transNoDestination;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTransTimeDestination() {
		return transTimeDestination;
	}

	public void setTransTimeDestination(String transTimeDestination) {
		this.transTimeDestination = transTimeDestination;
	}

	public String getTransNoDestination() {
		return transNoDestination;
	}

	public void setTransNoDestination(String transNoDestination) {
		this.transNoDestination = transNoDestination;
	}
	
	
}
