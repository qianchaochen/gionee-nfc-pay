package com.gionee.nfcPay.action.union;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.service.union.NfcUnionSmsService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**
 * OTP验证
 * 
 * @author dingyw
 *
 *         2017年6月15日
 */
@Service("verifySmsAction")
public class VerifySmsAction extends AbsBaseAction<BaseMsgVo> {
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 银联短信服务层
	 */
	@Autowired
	NfcUnionSmsService nfcUnionSmsService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo vo = (ReqMsgVo) msgVo;// 获取vo

		log.info("开始OTP验证：VerifySmsAction-->" + vo);
		VerifySmsRspVo verifySmsRspVo = this.verifySms(vo);

		// OPT申请返回成功
		RspMsgVo result = new RspMsgVo();
		result.setBody(verifySmsRspVo);
		log.info("VerifySmsAction result" + result);
		return result;
	}

	private VerifySmsRspVo verifySms(ReqMsgVo reqMsg) throws BizException {
		commomServiceCheckFacade.commonCheck(reqMsg.getHeader());

		commomServiceCheckFacade.checkUserToken(reqMsg.getHeader());

		VerifySmsReqVo verifySmsReqVo = (VerifySmsReqVo) reqMsg.getBody();
		commomServiceCheckFacade.checkVerifySmsReqVo(verifySmsReqVo);

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), verifySmsReqVo); // 初始化事务表
		try {

			VerifySmsRspVo verifySmsRspVo = nfcUnionSmsService.verifySmsSao(reqMsg);
			nfcUnionCoreTxnLogService.txn_success(txn, verifySmsRspVo);
			return verifySmsRspVo;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			this.onFail(txn, e); // 将事务置为失败
			throw e; // 将异常重新抛出
		}
	}

	// 覆盖父类的方法，实现业务逻辑
	public BaseMsgVo doAction(JSONObject json) throws Exception {
		log.info("getMsg:" + json);
		// 对于必须验签的，手工添加验证签名
		// commomServiceCheckFacade.checkEpaySign(json);

		BaseMsgVo msgVo = this.getMsgVo(json, VerifySmsReqVo.class);

		return this.execute(msgVo);
	}

}
