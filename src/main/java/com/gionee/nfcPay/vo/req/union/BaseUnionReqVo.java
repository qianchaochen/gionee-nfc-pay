package com.gionee.nfcPay.vo.req.union;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2017年6月13日
 */
public class BaseUnionReqVo extends BaseMsgVo{
	
	/**
	 * 安全载体CPLC
	 */
	private String xTsmCplc;
	
	/**
	 * 交易发起方流水号
	 */
	private String transNoSource;

	public String getxTsmCplc() {
		return xTsmCplc;
	}

	public void setxTsmCplc(String xTsmCplc) {
		this.xTsmCplc = xTsmCplc;
	}

	public String getTransNoSource() {
		return transNoSource;
	}

	public void setTransNoSource(String transNoSource) {
		this.transNoSource = transNoSource;
	}
}
