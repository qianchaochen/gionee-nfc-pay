package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.ApplySmsSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
import com.gionee.nfcPay.vo.rsp.ApplySmsRspVo;

/**
 * @author dingyw
 *
 *         2017年6月14日
 */
@Service
public class ApplySmsSaoImpl extends CommonUnionSaoImpl implements ApplySmsSao {

	Logger log = LoggerFactory.getLogger(getClass());
	private String union_apply_sms_url;

	@Override
	public ApplySmsRspVo applySms(ApplySmsReqVo vo) throws BizException {
		super.setHeaderMap(vo);
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("otpMethod", "OTPSMS");
		try {

			UnionResultVo resultVo = AmigoHttpUtils.unionPost(union_apply_sms_url + vo.getVirtualCardRefId(),
					jsonBody.toString(), super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(resultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联OPT申请失败");
			}
			ApplySmsRspVo applySmsRspVo = new ApplySmsRspVo();
			applySmsRspVo.setExpirationDate((String) resultJson.get("expirationDate"));
			applySmsRspVo.setTransNoDestination(resultVo.getTransNoDestination());
			applySmsRspVo.setTransTimeDestination(resultVo.getTransTimeDestination());
			
			return applySmsRspVo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联OPT申请失败");
		}
	}

	public String getUnion_apply_sms_url() {
		return union_apply_sms_url;
	}

	@Value("#{nfcPay_config['union_apply_sms_url']}")
	public void setUnion_apply_sms_url(String union_apply_sms_url) {
		this.union_apply_sms_url = union_apply_sms_url;
	}
}
