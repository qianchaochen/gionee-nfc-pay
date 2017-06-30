package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.nfcPay.vo.req.union.notify.SendTsmDataLibDataNotifyReqVo;

/**
 * @author dingyw
 *
 * 2017年6月29日
 */
public interface TsmLibDataNotifyService {
	
	/**
	 * 接收银联的TsmLibData的通知
	 */
	public void tsmLibDataNotify(SendTsmDataLibDataNotifyReqVo vo);

}
