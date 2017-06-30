package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class TsmLibDataVo extends BaseVo{
	
	/**
	 * APDU任务ID
	 */
	private String ssid;
	
	/**
	 * 签名
	 * 取值:sign
	 */
	private String sign;
	
	/**
	 * 事件，告知TSM控件
	 * 删除：DELETE
	      下载：DOWNLOAD
	       擦除：WIPEOUT
	 */
	private String event;

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	

}
