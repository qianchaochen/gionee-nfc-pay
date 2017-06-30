/**
 * 
 */
package com.gionee.nfcPay.action;

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
import com.gionee.nfcPay.vo.req.QueryCardListReqVo;
import com.gionee.nfcPay.vo.rsp.QueryCardListRspVo;

/**
 * 卡包列表查询,返回银联卡，公交卡列表
 * 
 * @author zhanggq
 *
 *         2017年6月24日
 */
@Service("queryCardListAction")
public class QueryCardListAction extends AbsBaseAction<BaseMsgVo> {
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 银联短信服务层
	 */
	@Autowired
	NfcUnionCardInfoService nfcUnionCardInfoService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo vo = (ReqMsgVo) msgVo;// 获取vo

		log.info("开始卡包列表查询：QueryCardListAction-->" + vo);
		QueryCardListRspVo cardListRspVo = this.queryCardList(vo);

		// OPT申请返回成功
		RspMsgVo result = new RspMsgVo();
		result.setBody(cardListRspVo);
		log.info("QueryCardListAction result" + result);
		return result;
	}

	private QueryCardListRspVo queryCardList(ReqMsgVo reqMsg) throws BizException {
		commomServiceCheckFacade.commonCheck(reqMsg.getHeader());

		commomServiceCheckFacade.checkUserToken(reqMsg.getHeader());

		QueryCardListReqVo queryCardListReqVo = (QueryCardListReqVo) reqMsg.getBody();
		commomServiceCheckFacade.checkQueryCardListReqVo(queryCardListReqVo);

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), queryCardListReqVo); // 初始化事务表
		try {

			QueryCardListRspVo cardListRspVo = nfcUnionCardInfoService.queryCardList(reqMsg);
			this.onSuccess(txn); // 将事务置为成功
			return cardListRspVo;
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

		BaseMsgVo msgVo = this.getMsgVo(json, QueryCardListReqVo.class);

		return this.execute(msgVo);
	}

}
