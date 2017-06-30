/**
 * 
 */
package com.gionee.nfcPay.service.union.notify.rcv.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardInfoTbMapper;
import com.gionee.nfcPay.service.union.notify.rcv.CardStatusChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCardInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyVirtualCardItemVo;

/**
 * @author zhanggq
 *
 * 2017年6月27日
 */
@Service
public class CardStatusChangeNotifyServiceImpl implements CardStatusChangeNotifyService {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NfcUnionCardInfoTbMapper nfcUnionCardInfoTbMapper;
	
	@Override
	public void updateCardProductInfoChangeNotify(CardStatusChangeNotifyReqVo vo)
			throws BizException {
		
		try {
			List<CardStatusChangeNotifyVirtualCardItemVo> cardItemList = vo.getVirtualCards();
			if(CollectionUtils.isEmpty(cardItemList)) {
				return;
			}
			
			Date nowDate = new Date();
			for(CardStatusChangeNotifyVirtualCardItemVo cardItem: cardItemList) {
				NfcUnionCardInfoTb record = new NfcUnionCardInfoTb();
				record.setVirtualCardRefId(cardItem.getVirtualCardRefId());
				record.setStatus(cardItem.getStatus());
				record.setLast_update_time(nowDate);
				nfcUnionCardInfoTbMapper.updateByPrimaryKey(record);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BizException(e.getMessage());
		}
	}

}
