package com.gionee.nfcPay.action.busCard;

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
import com.gionee.nfcPay.service.busCard.BusCardService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import com.gionee.nfcPay.vo.rsp.ClientAdviceUserActiveCardRspVo;

/**
 * 用户开通公交卡客户端通知服务端
 * @author:qiancc 2017年6月27日
 */

@Service("clientAdviceUserActiveCardAction")
public class ClientAdviceUserActiveCardAction extends AbsBaseAction<BaseMsgVo> {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BusCardService busCardService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo reqMsgVo = (ReqMsgVo) msgVo;
		log.info("开始客户端通知用户开卡操作：" + reqMsgVo);
		this.clientAdvice(reqMsgVo);
		RspMsgVo result = new RspMsgVo();
		log.info("result->" + result);
		return result;
	}

	private ClientAdviceUserActiveCardRspVo clientAdvice(ReqMsgVo reqMsgVo) throws BizException {
		commomServiceCheckFacade.commonCheck(reqMsgVo.getHeader());
		commomServiceCheckFacade.checkUserToken(reqMsgVo.getHeader());
		ClientAdviceUserActiveCardReqVo vo = (ClientAdviceUserActiveCardReqVo) reqMsgVo.getBody();
		commomServiceCheckFacade.checkClientAdviceUserActiveCardReqVo(vo);
		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsgVo.getHeader(), vo);
		try {
			ClientAdviceUserActiveCardRspVo result = busCardService
					.insertClientAdviceUserActiveCard(reqMsgVo);
			this.onSuccess(txn);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			this.onFail(txn, e);
			throw e;
		}
	}

	// 覆盖父类的方法，实现业务逻辑
	public BaseMsgVo doAction(JSONObject json) throws Exception {
		log.info("getMsg:" + json);
		// 对于必须验签的，手工添加验证签名
		// commomServiceCheckFacade.checkEpaySign(json);

		BaseMsgVo msgVo = this.getMsgVo(json, ClientAdviceUserActiveCardReqVo.class);

		return this.execute(msgVo);
	}
}
