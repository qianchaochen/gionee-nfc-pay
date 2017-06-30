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
import com.gionee.nfcPay.service.union.notify.rcv.CardStatusChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyReqVo;

/**设备卡状态变更通知
 * @author dingyw
 *
 * 2017年6月15日
 */
@Service("cardStatusChangeNotifyAction")
public class CardStatusChangeNotifyAction extends AbsBaseAction<BaseMsgVo>{
Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CardStatusChangeNotifyService cardStatusChangeNotifyService;
	
	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		UnionReqMsgVo vo = (UnionReqMsgVo) msgVo;// 获取vo

		log.info("开始设备卡状态变更通知：CardStatusChangeNotifyAction-->" + vo);
		
		this.cardStatusChangeNotify(vo);

		RspMsgVo result = new RspMsgVo();

		return result;
	}

	private void cardStatusChangeNotify(UnionReqMsgVo reqMsg) throws BizException {

		CardStatusChangeNotifyReqVo cardStatusChangeNotifyVo = (CardStatusChangeNotifyReqVo) reqMsg.getBody();

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), cardStatusChangeNotifyVo); // 初始化事务表
		try {

			cardStatusChangeNotifyService.updateCardProductInfoChangeNotify(cardStatusChangeNotifyVo);
			this.onSuccess(txn); // 将事务置为成功
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			this.onFail(txn, e); // 将事务置为失败
			throw e; // 将异常重新抛出
		}
	}

	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		log.info("getMsg:" + json);
		return this.getFastJsonMsgVo(json, CardStatusChangeNotifyReqVo.class);
	}

}
