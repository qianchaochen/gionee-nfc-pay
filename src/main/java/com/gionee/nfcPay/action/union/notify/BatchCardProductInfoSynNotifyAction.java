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
import com.gionee.nfcPay.service.union.notify.rcv.BatchCardProductInfoSynNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.notify.BatchCardProductInfoSynNotifyReqVo;

/**
 * 批量同步卡产品信息通知
 * @author dingyw
 *
 * 2017年6月15日
 */
@Service("batchCardProductInfoSynNotifyAction")
public class BatchCardProductInfoSynNotifyAction extends AbsBaseAction<BaseMsgVo>{

	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 接收银联批量产品信息通知服务层
	 */
	@Autowired
	BatchCardProductInfoSynNotifyService batchCardProductInfoSynNotifyService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		UnionReqMsgVo vo = (UnionReqMsgVo) msgVo;// 获取vo

		log.info("开始接收银联批量产品信息通知：BatchCardProductInfoSynNotifyAction-->" + vo);
		
		this.batchCardProductInfoSynNotify(vo);

		// 个人化结果通知返回，无 
		RspMsgVo result = new RspMsgVo();

		return result;
	}

	private void batchCardProductInfoSynNotify(UnionReqMsgVo reqMsg) throws BizException {

		BatchCardProductInfoSynNotifyReqVo batchCardProductInfoSynNotifyReqVo = (BatchCardProductInfoSynNotifyReqVo) reqMsg.getBody();

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(), batchCardProductInfoSynNotifyReqVo); // 初始化事务表
		try {

			batchCardProductInfoSynNotifyService.batchCardProductInfoSynNotify(batchCardProductInfoSynNotifyReqVo);
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
		return this.getFastJsonMsgVo(json, BatchCardProductInfoSynNotifyReqVo.class);
	}
	
}
