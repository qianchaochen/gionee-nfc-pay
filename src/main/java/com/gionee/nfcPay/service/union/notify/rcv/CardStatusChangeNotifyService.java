/**
 * 
 */
package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyReqVo;

/**
 * @author zhanggq
 *
 * 2017年6月27日
 */
public interface CardStatusChangeNotifyService {

	/**
	 * @param cardStatusChangeNotifyVo
	 */
	void updateCardProductInfoChangeNotify(CardStatusChangeNotifyReqVo cardStatusChangeNotifyVo) throws BizException;

}
