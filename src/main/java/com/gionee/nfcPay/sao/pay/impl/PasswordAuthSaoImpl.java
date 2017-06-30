/**
 * 
 */
package com.gionee.nfcPay.sao.pay.impl;

import java.io.IOException;




import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.pay.PasswordAuthSao;
import com.gionee.nfcPay.vo.req.union.PayPasswordAuthReqVo;
import com.gionee.nfcPay.vo.rsp.PayPasswordAuthRspVo;

/**
 * @author zhanggq
 *
 *         2017年6月27日
 */
@Service
public class PasswordAuthSaoImpl implements PasswordAuthSao {
	private String passwd_auth_url;
	public static String SUCCESS_CODE = "200000000";
	Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public PayPasswordAuthRspVo authPasswd(PayPasswordAuthReqVo passwdAuthReqVo) throws BizException {
		JSONObject passwdAuthJson = new JSONObject();

		JSONObject epayAuthJson = new JSONObject();
		epayAuthJson.put("uid", passwdAuthReqVo.getUid());
		epayAuthJson.put("passwd", passwdAuthReqVo.getPasswd());
		epayAuthJson.put("phone_no", passwdAuthReqVo.getPhone_no());
		epayAuthJson.put("is_support_fingerprint", passwdAuthReqVo.getIs_fingerprint());

		passwdAuthJson.put("user_token", passwdAuthReqVo.getUser_token());
		passwdAuthJson.put("app_id", "app_id");
		passwdAuthJson.put("epay_auth", epayAuthJson);
		
		log.info("passwdAuthJson:" + passwdAuthJson.toString());
		String response = null;
		try {
			response = AmigoHttpUtils.post(passwd_auth_url, passwdAuthJson.toString());

		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
		log.info("auth response:" + response);

		if (StringUtils.isEmpty(response)) {
			throw new BizException("支付系统校验密码失败");
		}

		JSONObject resultJson = (JSONObject)JSONValue.parse(response);
		if (resultJson == null) {
			throw new BizException("支付系统校验密码失败");
		}

		if (SUCCESS_CODE.equals(resultJson.get("status"))) {
			PayPasswordAuthRspVo rspVo = new PayPasswordAuthRspVo();
			String epay_auth_response = (String)resultJson.get("epay_auth_response");
			JSONObject epayJson = (JSONObject)JSONValue.parse(epay_auth_response);
			rspVo.setVerify_token((String)epayJson.get("verify_token"));
			rspVo.setBusi_no((String)epayJson.get("busi_no"));
			
			return rspVo;
		} else {
			return null;
		}

	}

	public String getPasswd_auth_url() {
		return passwd_auth_url;
	}

	@Value("#{nfcPay_config['passwd_auth_url']}")
	public void setPasswd_auth_url(String passwd_auth_url) {
		this.passwd_auth_url = passwd_auth_url;
	}

}
