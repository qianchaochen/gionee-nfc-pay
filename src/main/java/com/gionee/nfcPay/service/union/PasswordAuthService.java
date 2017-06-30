/**
 * 
 */
package com.gionee.nfcPay.service.union;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.vo.rsp.PayPasswordAuthRspVo;

/**
 * 密码校验业务层
 * @author zhanggq
 *
 * 2017年6月27日
 */
public interface PasswordAuthService {

	/**
	 * @param reqMsg
	 * @return
	 */
	PayPasswordAuthRspVo authPasswd(ReqMsgVo reqMsg) throws BizException;

}
