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
import com.gionee.nfcPay.service.union.NfcUnionCardInfoService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.QueryCardEventReqVo;
import com.gionee.nfcPay.vo.rsp.QueryCardEventRspVo;

/**
 * 轮询设备卡状态
 * 
 * @author dingyw
 *
 *         2017年6月17日
 */
@Service("queryCardEventAction")
public class QueryCardEventAction extends AbsBaseAction<BaseMsgVo> {
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 卡信息服务层
	 */
	@Autowired
	NfcUnionCardInfoService cardInfoService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo vo = (ReqMsgVo) msgVo;// 获取vo

		log.info("开始轮询设备卡状态：QueryCardEventAction-->" + vo);
		QueryCardEventRspVo queryCardEventRspVo = this.queryCardEvent(vo);

		// 卡bin校验返回成功
		RspMsgVo result = new RspMsgVo();
		result.setBody(queryCardEventRspVo);
		log.info("QueryCardEventAction result" + result);
		return result;
	}

	private QueryCardEventRspVo queryCardEvent(ReqMsgVo reqMsg) throws BizException {
		commomServiceCheckFacade.commonCheck(reqMsg.getHeader());

		commomServiceCheckFacade.checkUserToken(reqMsg.getHeader());

		QueryCardEventReqVo queryCardEventReqVo = (QueryCardEventReqVo) reqMsg.getBody();
		commomServiceCheckFacade.checkQueryCardEventReqVo(queryCardEventReqVo);

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), queryCardEventReqVo); // 初始化事务表
		try {

			QueryCardEventRspVo queryCardEventRspVo = cardInfoService.queryCardEvent(reqMsg);
			nfcUnionCoreTxnLogService.txn_success(txn, queryCardEventRspVo);
			return queryCardEventRspVo;
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

		BaseMsgVo msgVo = this.getMsgVo(json, QueryCardEventReqVo.class);

		return this.execute(msgVo);
	}
	//覆盖父类方法,如果返回报文需要签名，则返回true,默认是false
	public boolean is_need_sign(){
		return false;
	}
	//覆盖父类方法,如果返回报文需要签名，则返回true,默认是false
	public boolean is_need_encry(){
		return true;
	}
}
