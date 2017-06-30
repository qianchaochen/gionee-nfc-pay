package com.gionee.nfcPay.service.union.notify.rcv.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardInfoTbMapper;
import com.gionee.nfcPay.service.union.notify.rcv.CardInfoChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCardInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeNotifyReqVo;

/**
 *
 * @author: qiancc
 * 2017年06月28日
 */
@Service
public class CardInfoChangeNotifyServiceImpl implements CardInfoChangeNotifyService {

    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    NfcUnionCardInfoTbMapper nfcUnionCardInfoTbMapper;

    @Override
    public void updateCardInfoChangeNotify(CardInfoChangeNotifyReqVo vo) throws BizException {
        try {
            if (vo.getVirtualCardRefId() == null) {
                return;
            }
            NfcUnionCardInfoTb cardInfoTb = new NfcUnionCardInfoTb();
            cardInfoTb.setVirtualCardRefId(vo.getVirtualCardRefId());
            cardInfoTb.setCardReferenceId(vo.getCardReferenceId());
            cardInfoTb.setCardProductId(vo.getCardProductId());
            cardInfoTb.setLastDigits(vo.getLastDigits());
            Date date = new Date();
            cardInfoTb.setLast_update_time(date);
            nfcUnionCardInfoTbMapper.updateByPrimaryKeySelective(cardInfoTb);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new BizException(e.getMessage());
        }
    }
}
