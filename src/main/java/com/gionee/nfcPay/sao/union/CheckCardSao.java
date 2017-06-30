package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.CheckCardReqVo;
import com.gionee.nfcPay.vo.rsp.CheckCardRspVo;

/**卡bin校验
 * @author dingyw
 *
 * 2017年6月13日
 */
public interface CheckCardSao {
	
	/**校验卡bin
	 * @param vo
	 * @return
	 */
	public CheckCardRspVo checkCard(CheckCardReqVo vo) throws BizException;

}
