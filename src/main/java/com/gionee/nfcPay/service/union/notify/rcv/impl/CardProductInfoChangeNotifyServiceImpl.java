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
import com.gionee.nfcPay.dao.mapper.NfcUnionCardProductInfoTbMapper;
import com.gionee.nfcPay.sao.union.QueryCardProductInfoSao;
import com.gionee.nfcPay.service.union.notify.rcv.CardProductInfoChangeNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionCardProductInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardProductInfoChangeNotifyReqVo;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author zhanggq
 *
 *         2017年6月27日
 */
@Service
public class CardProductInfoChangeNotifyServiceImpl implements CardProductInfoChangeNotifyService {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	NfcUnionCardProductInfoTbMapper nfcUnionCardProductInfoTbMapper;
	@Autowired
	QueryCardProductInfoSao queryCardProductInfoSao;

	@Override
	public void cardProductInfoChangeNotify(CardProductInfoChangeNotifyReqVo cardProductChangeNotifyVo)
			throws BizException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 接收卡产品信息变更通知，比较版本，是更新版本怎请求获取卡产品信息
		NfcUnionCardProductInfoTb cardProductInfo = nfcUnionCardProductInfoTbMapper
				.selectByPrimaryKey(cardProductChangeNotifyVo.getCardProductId());
		Date nowDate = new Date();
		try {
			// 请求获取产品信息
			if (cardProductInfo == null) {
				NfcUnionCardProductInfoTb newCardProductInfo = queryCardProductInfoSao
						.queryCardProductInfo(cardProductChangeNotifyVo);
				newCardProductInfo.setLast_upd_time(nowDate);
				newCardProductInfo.setCreate_date(nowDate);
				newCardProductInfo.setCreate_time(nowDate);
				nfcUnionCardProductInfoTbMapper.insertSelective(newCardProductInfo);

			} else if (sf.parse(cardProductInfo.getVersion()).after(sf.parse(cardProductInfo.getVersion()))) {
				NfcUnionCardProductInfoTb newCardProductInfo = queryCardProductInfoSao
						.queryCardProductInfo(cardProductChangeNotifyVo);
				newCardProductInfo.setLast_upd_time(nowDate);
				nfcUnionCardProductInfoTbMapper.updateByPrimaryKeySelective(newCardProductInfo);
			}
			
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new BizException(e.getMessage());
		}

	}

}
