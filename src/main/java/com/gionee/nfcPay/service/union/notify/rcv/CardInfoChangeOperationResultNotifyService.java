package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;

/**
 * @author  qiancc
 * 2017年06月28日
 */
public interface CardInfoChangeOperationResultNotifyService {

    void updateCardInfoChangeOperationResultNotify(CardInfoChangeOperationResultNotifyReqVo vo) throws BizException;

}
