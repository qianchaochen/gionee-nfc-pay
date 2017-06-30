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
import com.gionee.nfcPay.vo.req.busCard.QuerySupportCitiesReqVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesRspVo;

/**
 * 查询开通的公交卡城市和协议
 * 
 * @author dingyw
 *
 *         2017年6月15日
 */
@Service("querySupportCitiesAction")
public class QuerySupportCitiesAction extends AbsBaseAction<BaseMsgVo> {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	BusCardService busCardService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws BizException {

		ReqMsgVo reqMsg = (ReqMsgVo) msgVo;// 获取vo

		QuerySupportCitiesReqVo vo = (QuerySupportCitiesReqVo) reqMsg.getBody();

		log.info("开始查询公交业务支持城市：QuerySupportCitiesAction-->" + vo);

		QuerySupportCitiesRspVo querySupportCitiesRspVo = busCardService.querySupportCities(vo);

		RspMsgVo result = new RspMsgVo();
		result.setBody(querySupportCitiesRspVo);
		log.info("result->" + result);
		return result;
	}

	// 覆盖父类的方法，实现业务逻辑
	public BaseMsgVo doAction(JSONObject json) throws Exception {
		log.info("getMsg:" + json);
		// 对于必须验签的，手工添加验证签名
		// commomServiceCheckFacade.checkEpaySign(json);

		BaseMsgVo msgVo = this.getMsgVo(json, QuerySupportCitiesReqVo.class);

		return this.execute(msgVo);
	}
}
