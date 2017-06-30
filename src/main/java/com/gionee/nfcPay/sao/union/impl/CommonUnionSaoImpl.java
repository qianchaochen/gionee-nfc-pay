/**
 * 
 */
package com.gionee.nfcPay.sao.union.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.gionee.common.utils.DateUtils;
import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author zhanggq
 *
 * 2017年6月22日
 */
public class CommonUnionSaoImpl {
	private Map<String, String> headerMap;
	/**
	 * 厂商机构代码
	 */
	private String xSmpsCallerid;
	

	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(BaseUnionReqVo baseReqVo) {
		this.headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "Content-Type:application/json; charset=utf-8");
		headerMap.put("x-tsm-cplc", baseReqVo.getxTsmCplc());
		headerMap.put("x-smps-callerid", this.xSmpsCallerid);
		headerMap.put("transTimeSource", DateUtils.getFormatSubmitTime(new Date()));
		headerMap.put("transNoSource", baseReqVo.getTransNoSource());
		
	}

	public String getxSmpsCallerid() {
		return xSmpsCallerid;
	}
	
	@Value("#{nfcPay_config['xSmpsCallerid']}")
	public void setxSmpsCallerid(String xSmpsCallerid) {
		this.xSmpsCallerid = xSmpsCallerid;
	}
	
}
