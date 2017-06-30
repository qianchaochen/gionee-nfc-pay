package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.VerifySmsSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**
 * @author dingyw
 *
 *         2017年6月14日
 */
@Service
public class VerifySmsSaoImpl extends CommonUnionSaoImpl implements VerifySmsSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String union_verify_sms_url;

	@Override
	public VerifySmsRspVo verifySms(VerifySmsReqVo vo) throws BizException {
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("otpValue", vo.getOtpValue());
		try {

			UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(
					union_verify_sms_url + vo.getVirtualCardRefId(), jsonBody.toString(),
					super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联OPT验证失败");
			}
			VerifySmsRspVo verifySmsRspVo = new VerifySmsRspVo();
			verifySmsRspVo.setVerifyResult((String) resultJson.get("verifyResult"));
			verifySmsRspVo.setTransNoDestination(unionResultVo.getTransNoDestination());
			verifySmsRspVo.setTransTimeDestination(unionResultVo.getTransTimeDestination());

			return verifySmsRspVo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联OPT验证失败");
		}
	}

	public String getUnion_verify_sms_url() {
		return union_verify_sms_url;
	}

	@Value("#{nfcPay_config['union_verify_sms_url']}")
	public void setUnion_verify_sms_url(String union_verify_sms_url) {
		this.union_verify_sms_url = union_verify_sms_url;
	}

}
