package com.gionee.nfcPay.action.union.notify;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.msg.union.UnionReqMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.service.union.notify.rcv.CardInfoChangeNotifyService;
import com.gionee.nfcPay.service.union.notify.rcv.CardInfoChangeOperationResultNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**卡面信息变更通知
 * @author dingyw
 *
 * 2017年6月15日
 */
@Service("cardInfoChangeNotifyAction")
public class CardInfoChangeNotifyAction extends AbsBaseAction<BaseMsgVo>{
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	CardInfoChangeNotifyService cardInfoChangeNotifyService;
	@Autowired
	CardInfoChangeOperationResultNotifyService cardInfoChangeOperationResultNotifyService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		UnionReqMsgVo reqMsgVo = (UnionReqMsgVo) msgVo;
		log.info("开始卡面信息变更通知:" + reqMsgVo);
		this.cardInfoChangeNotify(reqMsgVo);
		RspMsgVo result = new RspMsgVo();

		return result;
	}

	private void cardInfoChangeNotify(UnionReqMsgVo reqMsgVo) throws BizException {
		CardInfoChangeNotifyReqVo vo = (CardInfoChangeNotifyReqVo) reqMsgVo.getBody();
		//开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.tnx_init(reqMsgVo.getHeader(), vo);

		try {
			cardInfoChangeNotifyService.updateCardInfoChangeNotify(vo);//未发生异常，通知成功
			CardInfoChangeOperationResultNotifyReqVo resultNotifyReqVo = new CardInfoChangeOperationResultNotifyReqVo();
			resultNotifyReqVo.setTaskId(txn.getCardInfoChangeTaskId());//获取事务中的taskId
			resultNotifyReqVo.setVirtualCardRefId(txn.getVirtualCardRefId());
			resultNotifyReqVo.setEvent("METAUPDATE");
			resultNotifyReqVo.setResult("00");
			//更新卡面信息结果通知
			cardInfoChangeOperationResultNotifyService.updateCardInfoChangeOperationResultNotify(resultNotifyReqVo);

			this.onSuccess(txn);//将事务置为成功
		} catch (BizException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			this.onFail(txn, e);//将事务置为失败
			throw e;
		}

	}

	@Override
	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		return this.getMsgVo(json, CardInfoChangeNotifyReqVo.class);
	}
}
