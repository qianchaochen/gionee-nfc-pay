package com.gionee.nfcPay.service.union.notify.rcv.impl;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.sao.union.notify.CardInfoChangeResultNotifySao;
import com.gionee.nfcPay.service.union.notify.rcv.CardInfoChangeOperationResultNotifyService;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qiancc
 * 2017年06月28日
 */
@Service
public class CardInfoChangeOperationResultNotifyServiceImpl implements CardInfoChangeOperationResultNotifyService {

    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    CardInfoChangeResultNotifySao cardInfoChangeResultNotifySao;

    @Override
    public void updateCardInfoChangeOperationResultNotify(CardInfoChangeOperationResultNotifyReqVo vo) throws BizException {
        log.info("CardInfoChangeOperationResultNotifyReqVo:" + vo);
        cardInfoChangeResultNotifySao.cardInfoChangeResultNotify(vo);
    }
}
