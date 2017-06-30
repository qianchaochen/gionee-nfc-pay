package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class IdvMethodsVo extends BaseVo{
	
	/**
	 * 激活方法
	 * 请求BODY的applyChannel为“00”: NONE(银行)
	 * 请求BODY的applyChannel为“01”: OTPSMS(手机厂商) 手机短信验证

	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
