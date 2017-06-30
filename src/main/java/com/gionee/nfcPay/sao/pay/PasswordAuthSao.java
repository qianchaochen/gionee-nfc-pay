/**
 * 
 */
package com.gionee.nfcPay.sao.pay;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.PayPasswordAuthReqVo;
import com.gionee.nfcPay.vo.rsp.PayPasswordAuthRspVo;

/**
 * 去支付系统校验密码
 * @author zhanggq
 *
 * 2017年6月27日
 */
public interface PasswordAuthSao {

	/**
	 * @param reqMsg
	 */
	PayPasswordAuthRspVo authPasswd(PayPasswordAuthReqVo passwdAuthReqVo) throws BizException;

}
