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
import com.gionee.nfcPay.service.union.NfcUnionDeviceInfoService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.union.DeviceStatusChangeReqVo;

/**
 * 设备状态变更 交易方向：金立->银联
 * 
 * @author dingyw
 *
 *         2017年6月15日
 */
@Service("deviceStatusChangeAction")
public class DeviceStatusChangeAction extends AbsBaseAction<BaseMsgVo> {
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 设备状态服务层
	 */
	@Autowired
	NfcUnionDeviceInfoService nfcUnionDeviceInfoService;

	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws Exception {
		ReqMsgVo vo = (ReqMsgVo) msgVo;// 获取vo

		log.info("开始设备状态变更：DeviceStatusChangeAction-->" + vo);
		this.deviceStatusChange(vo);

		// 设备状态变更返回成功
		RspMsgVo result = new RspMsgVo();
		log.info("DeviceStatusChangeAction result" + result);
		return result;
	}

	private RspMsgVo deviceStatusChange(ReqMsgVo reqMsg) throws BizException {
		commomServiceCheckFacade.commonCheck(reqMsg.getHeader());

		commomServiceCheckFacade.checkUserToken(reqMsg.getHeader());

		DeviceStatusChangeReqVo deviceStatusChangeReqVo = (DeviceStatusChangeReqVo) reqMsg.getBody();

		// 开启事务
		NfcUnionCoreTxnLog txn = nfcUnionCoreTxnLogService.txn_init(reqMsg.getHeader(),
				deviceStatusChangeReqVo); // 初始化事务表
		try {

			RspMsgVo rspMsgVo = nfcUnionDeviceInfoService.updateDeviceStatusChange(reqMsg);
			this.onSuccess(txn); // 将事务置为成功
			return rspMsgVo;
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

		BaseMsgVo msgVo = this.getMsgVo(json, DeviceStatusChangeReqVo.class);

		return this.execute(msgVo);
	}

}
