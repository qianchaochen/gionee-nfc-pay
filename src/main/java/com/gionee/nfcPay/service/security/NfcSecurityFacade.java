package com.gionee.nfcPay.service.security;

import net.sf.json.JSONObject;

import com.gionee.common.exception.BizException;
import com.gionee.epay.client.EpaySDKRcv;

/**
 * @author dingyw
 *
 * 2017年6月27日
 */
public interface NfcSecurityFacade {
	/**
	 * @param json
	 * @return
	 * @throws BizException
	 */
	public  EpaySDKRcv decryptReqMessage(JSONObject json) throws BizException;

}
