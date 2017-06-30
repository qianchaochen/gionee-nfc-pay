package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.DeviceStatusChangeReqVo;

/**设备状态变更
 * @author dingyw
 *
 * 2017年6月15日
 */
public interface DeviceStatusChangeSao {

	/**
	 * 设备状态变更
	 * @param vo
	 */
	void changeDeviceStatus(DeviceStatusChangeReqVo vo) throws BizException;

}
