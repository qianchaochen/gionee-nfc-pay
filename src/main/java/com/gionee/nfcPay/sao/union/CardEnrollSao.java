package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.CardEnrollReqVo;
import com.gionee.nfcPay.vo.rsp.CardEnrollUnionRspVo;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public interface CardEnrollSao {
	
	/**卡申请接口
	 * @param vo
	 * @return
	 */
	public CardEnrollUnionRspVo cardEnroll(CardEnrollReqVo vo) throws BizException;

}
