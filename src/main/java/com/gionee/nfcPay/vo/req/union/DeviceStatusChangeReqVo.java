package com.gionee.nfcPay.vo.req.union;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class DeviceStatusChangeReqVo extends BaseUnionReqVo{
	
	/**
	 * 改变设备状态的操作
	 *  设备锁定：LOCK_DEVICE
		设备擦除：WIPE_DEVICE
	        设备重置：RESET_DEVICE
	 */
	private String event;
	
	/**
	 * 安全载体CPLC
	 */
	private String secureElement;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getSecureElement() {
		return secureElement;
	}

	public void setSecureElement(String secureElement) {
		this.secureElement = secureElement;
	}

}
