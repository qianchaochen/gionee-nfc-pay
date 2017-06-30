package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.nfcPay.vo.req.union.notify.PersonizeResultNotifyReqVo;

/**个人化结果通知
 * @author dingyw
 *
 * 2017年6月27日
 */
public interface PersonizeResultNotifyService {
	
	/**
	 * @param vo
	 */
	public void personizeResultNotify(PersonizeResultNotifyReqVo vo);

}
