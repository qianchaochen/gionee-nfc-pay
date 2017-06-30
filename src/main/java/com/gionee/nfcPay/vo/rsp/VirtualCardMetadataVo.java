package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class VirtualCardMetadataVo extends BaseVo{
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	
	/**
	 * 设备卡卡号，格式623524******0001
	 */
	private String virtualCardNum;
	
	/**
	 * 身份验证方法
	 */
	private IdvMethodsVo idvMethods;

	public String getVirtualCardRefId() {
		return virtualCardRefId;
	}

	public void setVirtualCardRefId(String virtualCardRefId) {
		this.virtualCardRefId = virtualCardRefId;
	}

	public String getVirtualCardNum() {
		return virtualCardNum;
	}

	public void setVirtualCardNum(String virtualCardNum) {
		this.virtualCardNum = virtualCardNum;
	}

	public IdvMethodsVo getIdvMethods() {
		return idvMethods;
	}

	public void setIdvMethods(IdvMethodsVo idvMethods) {
		this.idvMethods = idvMethods;
	}
	
	

}
