package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.models.NfcUnionCardProductInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardProductInfoChangeNotifyReqVo;

/**
 * 获取卡产品信息
 * 
 * @author dingyw
 *
 *         2017年6月15日
 */
public interface QueryCardProductInfoSao {

	/**
	 * 去银联查询卡产品信息
	 * 
	 * @param cardProductChangeNotifyVo
	 */
	public NfcUnionCardProductInfoTb queryCardProductInfo(
			CardProductInfoChangeNotifyReqVo cardProductChangeNotifyVo) throws BizException;

}
