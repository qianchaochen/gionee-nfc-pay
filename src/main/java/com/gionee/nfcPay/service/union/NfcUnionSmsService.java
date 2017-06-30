/**
 * 
 */
package com.gionee.nfcPay.service.union;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.vo.rsp.ApplySmsRspVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**
 * @author zhanggq
 *
 * 2017年6月20日
 */
public interface NfcUnionSmsService {

	/**
	 * @param reqMsg
	 * @return
	 */
	ApplySmsRspVo applySms(ReqMsgVo reqMsg) throws BizException;

	/**
	 * @param reqMsg
	 * @return
	 * @throws BizException
	 */
	VerifySmsRspVo verifySmsSao(ReqMsgVo reqMsg) throws BizException;

}
