package com.gionee.common.utils;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gionee.common.exception.BizException;
import com.gionee.epay.client.EpaySDKRcv;


/**
 * @author dingyw
 *
 * 2017年6月27日
 */

public class EpaySecurityUtils {
	
	Logger log = LoggerFactory.getLogger(getClass());

	public static EpaySDKRcv decryptReqMessage(JSONObject json,String public_key) throws BizException {

		String version = json.getString("version");

		if (StringUtils.isEmpty(version)) {
			throw new BizException("version不能为空");
		}

		try {
			EpaySDKRcv epaySDKRcv = new EpaySDKRcv(public_key);

			// 结果放在epaySDKRcvReq的message中,不仅需要返回解密后的message,而且要返回整个对象
			epaySDKRcv.getRcvMsg(json.toString());

			return epaySDKRcv;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BizException("解密过程发生异常");
		}

	}

}
