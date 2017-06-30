/**
 * 
 */
package com.gionee.nfcPay.service.union.notify.rcv.impl;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.union.UnionReqMsgVo;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardIssuerInfoTbMapper;
import com.gionee.nfcPay.sao.union.QueryCardIssuerInfoSao;
import com.gionee.nfcPay.service.union.notify.rcv.IssuerInfoChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCardIssuerInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardIssuerInfoChangeNotifyReqVo;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author zhanggq
 *
 *         2017年6月27日
 */
@Service
public class IssuerInfoChangeNotifyServiceImpl implements IssuerInfoChangeNotifyService {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	NfcUnionCardIssuerInfoTbMapper nfcUnionCardIssuerInfoTbMapper;
	@Autowired
	QueryCardIssuerInfoSao queryCardIssuerInfoSao;

	@Override
	public void cardIssuerInfoChangeNotify(UnionReqMsgVo reqMsg) throws BizException {
		CardIssuerInfoChangeNotifyReqVo reqVo = (CardIssuerInfoChangeNotifyReqVo) reqMsg.getBody();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		NfcUnionCardIssuerInfoTb cardIssuerInfo = nfcUnionCardIssuerInfoTbMapper
				.selectByPrimaryKey(reqVo.getIssuerId());
		
		Date nowDate = new Date();
		try {
			if (cardIssuerInfo == null) {
				NfcUnionCardIssuerInfoTb newCardIssuerInfo = queryCardIssuerInfoSao
						.queryCardIssuerInfo(reqVo);
				newCardIssuerInfo.setLast_upd_time(nowDate);
				newCardIssuerInfo.setCreate_date(nowDate);
				newCardIssuerInfo.setCreate_time(nowDate);
				nfcUnionCardIssuerInfoTbMapper.insertSelective(newCardIssuerInfo);

			} else if (sf.parse(cardIssuerInfo.getVersion()).after(sf.parse(cardIssuerInfo.getVersion()))) {
				NfcUnionCardIssuerInfoTb newCardIssuerInfo = queryCardIssuerInfoSao
						.queryCardIssuerInfo(reqVo);
				newCardIssuerInfo.setLast_upd_time(nowDate);
				nfcUnionCardIssuerInfoTbMapper.updateByPrimaryKeySelective(newCardIssuerInfo);
			}

		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new BizException(e.getMessage());
		}
	}

}
