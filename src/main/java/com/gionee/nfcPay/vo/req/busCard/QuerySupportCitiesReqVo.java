package com.gionee.nfcPay.vo.req.busCard;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月17日
 */
public class QuerySupportCitiesReqVo extends BaseVo{
	
	/**
	 *客户端版本号，待扩展 
	 */
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
