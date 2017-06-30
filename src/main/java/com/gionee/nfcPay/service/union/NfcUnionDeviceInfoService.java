/**
 * 
 */
package com.gionee.nfcPay.service.union;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;

/**
 * @author zhanggq
 *
 * 2017年6月20日
 */
public interface NfcUnionDeviceInfoService {

	/**
	 * @param reqMsg
	 * @return
	 */
	RspMsgVo updateDeviceStatusChange(ReqMsgVo reqMsg) throws BizException;

}
