package com.gionee.nfcPay.action.union.notify;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.msg.union.UnionReqMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.service.union.notify.rcv.TransResultNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.notify.TransResultNotifyReqVo;

/**
 * 交易结果通知(银联->金立)
 * 
 * @author dingyw
 * 
 *         2017年6月15日
 */
@Service("transResultNotifyAction")
public class TransResultNotifyAction extends AbsBaseAction<BaseMsgVo> {

	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 交易结果通知服务层
	 */
	@Autowired
	TransResultNotifyService transResultNotifyService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {

		UnionReqMsgVo vo = (UnionReqMsgVo) msgVo;

		log.info("开始交易结果通知：TransResultNotifyAction-->" + vo);

		this.insertTransResultNotify(vo);

		RspMsgVo result = new RspMsgVo();

		return result;
	}

	private void insertTransResultNotify(UnionReqMsgVo reqMsgVo)
			throws BizException {
		TransResultNotifyReqVo transResultNotifyReqVo = (TransResultNotifyReqVo) reqMsgVo
				.getBody();
		commomServiceCheckFacade
				.checkTransResultNotifyReqVo(transResultNotifyReqVo);

		// 开启事物
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(
				reqMsgVo.getHeader(), transResultNotifyReqVo);

		try {
			transResultNotifyService.insertTransResultNotify(
					reqMsgVo.getHeader(), transResultNotifyReqVo);
			this.onSuccess(txn);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			this.onFail(txn, e);
			throw e;
		}
	}

	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		log.info("getMsg:" + json);

		return this.getFastJsonMsgVo(json, TransResultNotifyReqVo.class);
	}

}
