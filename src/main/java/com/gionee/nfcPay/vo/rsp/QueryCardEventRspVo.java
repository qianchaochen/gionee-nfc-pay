/**
 * 
 */
package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseVo;

/**
 * @author zhanggq
 *
 * 2017年6月21日
 */
/**
 * @author zhanggq
 *
 * 2017年6月21日
 */
/**
 * @author zhanggq
 *
 *         2017年6月21日
 */
public class QueryCardEventRspVo extends BaseVo {

	/**
	 * APDU任务ID
	 */
	private String ssid;
	/**
	 * 取值sign
	 */
	private String sign;
	/**
	 * 需要TSM操作的事件
	 */
	private String tsm_event;
	
	/**
	 * 应用id
	 */
	private String aid;

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

	public String getTsm_event() {
		return tsm_event;
	}

	public void setTsm_event(String tsm_event) {
		this.tsm_event = tsm_event;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
}
