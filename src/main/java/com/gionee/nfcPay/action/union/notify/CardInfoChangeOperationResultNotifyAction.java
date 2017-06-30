/**
 * 
 */
package com.gionee.nfcPay.action.union.notify;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.msg.union.UnionReqMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.service.union.notify.rcv.CardInfoChangeOperationResultNotifyService;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卡面信息操作结果通知
 * @author zhanggq
 *
 * 2017年6月27日
 */
@Service("cardInfoChangeOperationResultNotifyAction")
public class CardInfoChangeOperationResultNotifyAction extends AbsBaseAction<BaseMsgVo>{

	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	CardInfoChangeOperationResultNotifyService cardInfoChangeOperationResultNotifyService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		UnionReqMsgVo unionReqMsgVo = (UnionReqMsgVo) msgVo;
		CardInfoChangeOperationResultNotifyReqVo vo = (CardInfoChangeOperationResultNotifyReqVo) unionReqMsgVo.getBody();

		cardInfoChangeOperationResultNotifyService.updateCardInfoChangeOperationResultNotify(vo);
		RspMsgVo result = new RspMsgVo();
		return result;
	}

}