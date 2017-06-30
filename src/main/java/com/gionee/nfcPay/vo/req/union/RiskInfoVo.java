package com.gionee.nfcPay.vo.req.union;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class RiskInfoVo extends BaseVo{
	
	/**
	 * 具体设备型号
	 * 用户给设备所添加的设备名称，比如“**的手机”。
	 */
	private String deviceName;
	
	/**
	 * 用来做设备卡加载时的用户设备位置信息
	 * 用来做设备卡加载时的用户设备位置信息，
	 * 但精度比deviceLocationType更高，有小数点。格式为纬度/经度，
	 * +表示北纬、东经，-表示南纬、西经。举例：+37.12/-121.23或者+37/-121
	 */
	private String extensiveDeviceLocation;
	
	/**
	 * 卡号录入方式
	 * manual：用户手输入卡号，camera：表示摄像头捕捉得到卡号，
	 * unknow：未知的获取卡号方式。
	    银联技术部已新增取值定义nfc,表示nfc读卡。
	    摄像头捕捉或nfc读卡经手工修改卡号后，均应填写为manual，表示手工输入。
	 */
	private String captureMethod;
	
	/**
	 * 用来做设备卡加载时用户设备所对应的手机号码后四位数字。
	 */
	private String deviceNumber;
	
	/**
	 * 持卡人用来做设备卡加载时所使用设备的号码，多个号码用逗号隔开。
	 */
	private String fullDeviceNumber;
	
	/**
	 * 设备厂商提供的持卡人通过智能设备申请设备卡时，智能设备IP信息。
	 */
	private String sourceIP;
	
	/**
	 * 智能设备中的SIM卡数量
	 */
	private String deviceSIMNumber;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getExtensiveDeviceLocation() {
		return extensiveDeviceLocation;
	}

	public void setExtensiveDeviceLocation(String extensiveDeviceLocation) {
		this.extensiveDeviceLocation = extensiveDeviceLocation;
	}

	public String getCaptureMethod() {
		return captureMethod;
	}

	public void setCaptureMethod(String captureMethod) {
		this.captureMethod = captureMethod;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getFullDeviceNumber() {
		return fullDeviceNumber;
	}

	public void setFullDeviceNumber(String fullDeviceNumber) {
		this.fullDeviceNumber = fullDeviceNumber;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	public String getDeviceSIMNumber() {
		return deviceSIMNumber;
	}

	public void setDeviceSIMNumber(String deviceSIMNumber) {
		this.deviceSIMNumber = deviceSIMNumber;
	}
	
	

}
