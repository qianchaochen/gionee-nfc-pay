/**
 * 
 */
package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.union.UnionReqMsgVo;

/**
 * 发卡行信息变更业务层
 * @author zhanggq
 *
 * 2017年6月27日
 */
public interface IssuerInfoChangeNotifyService {

	/**
	 * @param reqMsg
	 */
	void cardIssuerInfoChangeNotify(UnionReqMsgVo reqMsg) throws BizException;

}
