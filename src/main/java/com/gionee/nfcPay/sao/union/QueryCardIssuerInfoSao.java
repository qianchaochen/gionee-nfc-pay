package com.gionee.nfcPay.sao.union;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.models.NfcUnionCardIssuerInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardIssuerInfoChangeNotifyReqVo;

/**获取发卡行信息
 * @author dingyw
 *
 * 2017年6月15日
 */
public interface QueryCardIssuerInfoSao {

	/**
	 * @param reqVo
	 * @return
	 */
	NfcUnionCardIssuerInfoTb queryCardIssuerInfo(CardIssuerInfoChangeNotifyReqVo reqVo) throws BizException;

}
