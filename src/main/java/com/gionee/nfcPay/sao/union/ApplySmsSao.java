package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
import com.gionee.nfcPay.vo.rsp.ApplySmsRspVo;

/**OTP申请
 * @author dingyw
 *
 * 2017年6月14日
 */
public interface ApplySmsSao {
	
	/**申请短信验证码
	 * @param vo
	 * @return
	 */
	public ApplySmsRspVo applySms(ApplySmsReqVo vo) throws BizException;

}
