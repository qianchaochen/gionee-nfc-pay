package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.nfcPay.vo.req.union.notify.BatchCardProductInfoSynNotifyReqVo;

/**批量同步卡产品信息
 * @author dingyw
 *
 * 2017年6月29日
 */
public interface BatchCardProductInfoSynNotifyService {
	
	/**
	 * @param vo
	 */
	public void batchCardProductInfoSynNotify(BatchCardProductInfoSynNotifyReqVo vo);

}
