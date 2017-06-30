package com.gionee.common.msg.union;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2017年6月27日
 */
public class UnionMsgReqHeaderVo extends BaseMsgVo{
	/**
	 * 安全载体CPLC
	 */
	private String xTsmCplc;
	/**
	 * 交易请求方标识
	 */
	private String xSmpsCallerid;
	
	private String 	trans_code	;//	交易代码

	/**
	 * 发起方交易时间
	 */
	private String transTimeSource;
	/**
	 * 交易发起方流水号
	 */
	private String  transNoSource;
	
	private String ip;//ip信息

	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}

	
	public String getxTsmCplc() {
		return xTsmCplc;
	}
	public void setxTsmCplc(String xTsmCplc) {
		this.xTsmCplc = xTsmCplc;
	}
	public String getxSmpsCallerid() {
		return xSmpsCallerid;
	}
	public void setxSmpsCallerid(String xSmpsCallerid) {
		this.xSmpsCallerid = xSmpsCallerid;
	}
	public String getTransTimeSource() {
		return transTimeSource;
	}
	public void setTransTimeSource(String transTimeSource) {
		this.transTimeSource = transTimeSource;
	}
	public String getTransNoSource() {
		return transNoSource;
	}
	public void setTransNoSource(String transNoSource) {
		this.transNoSource = transNoSource;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

}
