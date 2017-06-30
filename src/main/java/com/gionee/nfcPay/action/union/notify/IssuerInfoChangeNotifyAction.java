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
import com.gionee.nfcPay.service.union.notify.rcv.IssuerInfoChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.notify.CardIssuerInfoChangeNotifyReqVo;

/**发卡行信息变更通知
 * 收到发卡行信息变更通知,需要比较版本,比当前版本更新则要请求获取发卡行信息,进行更新
 * @author dingyw
 *
 * 2017年6月15日
 */
@Service(value="issuerInfoChangeNotifyAction")
public class IssuerInfoChangeNotifyAction extends AbsBaseAction<BaseMsgVo>{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	IssuerInfoChangeNotifyService issuerInfoChangeService;
	
	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		UnionReqMsgVo vo = (UnionReqMsgVo) msgVo;// 获取vo

		log.info("开始发卡行信息变更通知：IssuerInfoChangeAction-->" + vo);
		
		this.cardIssuerInfoChange(vo);

		RspMsgVo result = new RspMsgVo();

		return result;
	}

	private void cardIssuerInfoChange(UnionReqMsgVo reqMsg) throws BizException {

		CardIssuerInfoChangeNotifyReqVo issuerInfoChangeReqVo = (CardIssuerInfoChangeNotifyReqVo) reqMsg.getBody();

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), issuerInfoChangeReqVo); // 初始化事务表
		try {

			issuerInfoChangeService.cardIssuerInfoChangeNotify(reqMsg);
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
		return this.getFastJsonMsgVo(json, CardIssuerInfoChangeNotifyReqVo.class);
	}


}
