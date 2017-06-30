/**
 * 
 */
package com.gionee.nfcPay.service.union.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.sao.union.ApplySmsSao;
import com.gionee.nfcPay.sao.union.VerifySmsSao;
import com.gionee.nfcPay.service.union.NfcUnionSmsService;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.rsp.ApplySmsRspVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**
 * @author zhanggq
 *
 * 2017年6月20日
 */
@Service
public class NfcUnionSmsServiceImpl implements NfcUnionSmsService{
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ApplySmsSao applySmsSao;
	@Autowired
	VerifySmsSao verifySmsSao;
	
	
	@Override
	public ApplySmsRspVo applySms(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			ApplySmsReqVo vo = (ApplySmsReqVo) reqMsg.getBody();
			// 设置返回参数
			ApplySmsRspVo result = applySmsSao.applySms(vo);
			log.info("applySmsSao result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("OPT申请失败");
		}
	}
	
	@Override
	public VerifySmsRspVo verifySmsSao(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			VerifySmsReqVo vo = (VerifySmsReqVo) reqMsg.getBody();
			// 设置返回参数
			VerifySmsRspVo result = verifySmsSao.verifySms(vo);
			log.info("verifySmsSao:{}", result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("OPT验证失败");
		}
	}

}
