/**
 * 
 */
package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.QueryCardIssuerInfoSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.models.NfcUnionCardIssuerInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardIssuerInfoChangeNotifyReqVo;

/**
 * @author zhanggq
 *
 * 2017年6月28日
 */
@Service
public class QueryCardIssuerInfoSaoImpl extends CommonUnionSaoImpl implements QueryCardIssuerInfoSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String query_card_issuer_info_url;

	@Override
	public NfcUnionCardIssuerInfoTb queryCardIssuerInfo(CardIssuerInfoChangeNotifyReqVo vo)
			throws BizException {
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("issuerId", vo.getIssuerId());
		try {

			UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(
					query_card_issuer_info_url + vo.getIssuerId(), jsonBody.toString(),
					super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联获取发卡行信息失败");
			}

			NfcUnionCardIssuerInfoTb cardIssuerInfo = new NfcUnionCardIssuerInfoTb();
			cardIssuerInfo.setContactNumber((String) resultJson.get("contactNumber"));
			cardIssuerInfo.setDebitCallCenterNumber((String) resultJson.get("debitCallCenterNumber"));
			cardIssuerInfo.setDebitEmail((String) resultJson.get("debitEmail"));
			cardIssuerInfo.setDebitTcUrl((String) resultJson.get("debitTcUrl"));
			cardIssuerInfo.setDebitWebsite((String) resultJson.get("debitWebsite"));
			cardIssuerInfo.setDescription((String) resultJson.get("description"));
			cardIssuerInfo.setIssuerId((String) resultJson.get("issuerId"));
			cardIssuerInfo.setLogo((String) resultJson.get("logo"));
			cardIssuerInfo.setMobileAppList((String) resultJson.get("mobileAppList"));
			cardIssuerInfo.setName((String) resultJson.get("name"));
			cardIssuerInfo.setTcOption((String) resultJson.get("tcOption"));
			cardIssuerInfo.setVersion((String) resultJson.get("version"));
			
			return cardIssuerInfo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联获取发卡行信息失败");
		}
	}

	public String getQuery_card_issuer_info_url() {
		return query_card_issuer_info_url;
	}

	@Value("#{nfcPay_config['union_query_card_issuer_info_url']}")
	public void setQuery_card_issuer_info_url(String query_card_issuer_info_url) {
		this.query_card_issuer_info_url = query_card_issuer_info_url;
	}


}
