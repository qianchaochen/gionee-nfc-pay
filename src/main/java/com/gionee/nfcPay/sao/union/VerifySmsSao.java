package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**OTP验证
 * @author dingyw
 *
 * 2017年6月14日
 */
public interface VerifySmsSao {
	
	/**
	 * @param vo
	 * @return
	 */
	public VerifySmsRspVo verifySms(VerifySmsReqVo vo) throws BizException;

}
