/**
 * 
 */
package com.gionee.nfcPay.service.union.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.nfcPay.dao.mapper.NfcUnionDeviceInfoTbMapper;
import com.gionee.nfcPay.sao.union.DeviceStatusChangeSao;
import com.gionee.nfcPay.service.union.NfcUnionDeviceInfoService;
import com.gionee.nfcPay.vo.models.NfcUnionDeviceInfoTb;
import com.gionee.nfcPay.vo.req.union.DeviceStatusChangeReqVo;

/**
 * @author zhanggq
 *
 * 2017年6月20日
 */
@Service
public class NfcUnionDeviceInfoServiceImpl implements NfcUnionDeviceInfoService{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private DeviceStatusChangeSao deviceStatusChangeSao;
	
	@Autowired
	NfcUnionDeviceInfoTbMapper NfcUnionDeviceInfoTbMapper;
	
	@Override
	public RspMsgVo updateDeviceStatusChange(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			DeviceStatusChangeReqVo vo = (DeviceStatusChangeReqVo) reqMsg.getBody();
			
			deviceStatusChangeSao.changeDeviceStatus(vo);
			
			log.info("deviceStatusChangeSao success");
			NfcUnionDeviceInfoTb record = new NfcUnionDeviceInfoTb();
			record.setStatus(vo.getEvent());
			record.setLast_upd_time(new Date());
			record.setxTsmCplc(vo.getSecureElement());

			NfcUnionDeviceInfoTbMapper.updateByPrimaryKeySelective(record);
			
			RspMsgVo result = new RspMsgVo();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("设备卡状态变更失败");
		}
	}

}
