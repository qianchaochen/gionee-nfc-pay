package com.gionee.nfcPay.action.busCard;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.facade.CommomServiceCheckFacade;
import com.gionee.nfcPay.service.busCard.BusCardService;
import com.gionee.nfcPay.vo.req.busCard.OperationCtrlReqVo;

/**
 * 公交卡业务权限控制
 * 
 * @author dingyw
 *
 *         2017年6月16日
 */
@Service("operationCtrlAction")
public class OperationCtrlAction extends AbsBaseAction<BaseMsgVo> {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	BusCardService busCardService;
	@Autowired
	CommomServiceCheckFacade commomServiceCheckFacade;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo reqMsgVo = (ReqMsgVo) msgVo;

		commomServiceCheckFacade.commonCheck(reqMsgVo.getHeader());
		OperationCtrlReqVo vo = (OperationCtrlReqVo) reqMsgVo.getBody();

		logger.info("开始查询公交业务权限：OperationCtrlAction-->" + vo);

		busCardService.queryOperationCtrl(vo);

		RspMsgVo result = new RspMsgVo();
		logger.info("result->" + result);
		return result;
	}

	// 覆盖父类的方法，实现业务逻辑
	public BaseMsgVo doAction(JSONObject json) throws Exception {
		logger.info("getMsg:" + json);
		// 对于必须验签的，手工添加验证签名
		// commomServiceCheckFacade.checkEpaySign(json);

		BaseMsgVo msgVo = this.getMsgVo(json, OperationCtrlReqVo.class);

		return this.execute(msgVo);
	}

}
