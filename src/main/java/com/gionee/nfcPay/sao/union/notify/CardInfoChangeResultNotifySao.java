package com.gionee.nfcPay.sao.union.notify;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;

/**卡面更新操作结果通知
 * 金立->银联
 * @author dingyw
 *
 * 2017年6月15日
 */
public interface CardInfoChangeResultNotifySao {

    void cardInfoChangeResultNotify(CardInfoChangeOperationResultNotifyReqVo vo) throws BizException;

}
