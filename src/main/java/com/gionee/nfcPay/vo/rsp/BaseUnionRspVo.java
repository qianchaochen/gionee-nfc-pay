package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月13日
 */
public class BaseUnionRspVo extends BaseVo{
	
	/**
	 * 接收方交易时间
	 * yyyyMMddhhmmss
	 */
	private String transTimeDestination;
	
	/**
	 * 交易接收方流水号
	 */
	private String transNoDestination;

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
