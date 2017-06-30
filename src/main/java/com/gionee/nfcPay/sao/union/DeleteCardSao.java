package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.DeleteCardReqVo;
import com.gionee.nfcPay.vo.rsp.DeleteCardRspVo;

/**设备卡删除
 * @author dingyw
 *
 * 2017年6月14日
 */
public interface DeleteCardSao {
	
	/**删除卡设备
	 * @param vo
	 * @return
	 */
	public DeleteCardRspVo deleteCard(DeleteCardReqVo vo) throws BizException;
	
	

}
