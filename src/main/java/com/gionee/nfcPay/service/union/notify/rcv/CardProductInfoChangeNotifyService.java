/**
 * 
 */
package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.notify.CardProductInfoChangeNotifyReqVo;

/**
 * 卡产品信息变更通知业务层
 * 
 * @author zhanggq
 *
 *         2017年6月27日
 */
public interface CardProductInfoChangeNotifyService {

	/**
	 * @param personizeResultNotifyReqVo
	 */
	void cardProductInfoChangeNotify(CardProductInfoChangeNotifyReqVo cardProductInfoChangeNotifyReqVo)
			throws BizException;

}
