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
import com.gionee.nfcPay.sao.union.QueryCardProductInfoSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.models.NfcUnionCardProductInfoTb;
import com.gionee.nfcPay.vo.req.union.notify.CardProductInfoChangeNotifyReqVo;

/**
 * @author zhanggq
 *
 *         2017年6月28日
 */
@Service
public class QueryCardProductInfoSaoImpl extends CommonUnionSaoImpl implements QueryCardProductInfoSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String query_card_product_info_url;

	@Override
	public NfcUnionCardProductInfoTb queryCardProductInfo(CardProductInfoChangeNotifyReqVo vo)
			throws BizException {
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("cardProductId", vo.getCardProductId());
		try {

			UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(
					query_card_product_info_url + vo.getCardProductId(), jsonBody.toString(),
					super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联删除卡失败");
			}

			NfcUnionCardProductInfoTb cardProductInfo = new NfcUnionCardProductInfoTb();
			cardProductInfo.setCardProductId((String) resultJson.get("cardProductId"));
			cardProductInfo.setCardArt((String) resultJson.get("cardArt"));
			cardProductInfo.setDisplayName((String) resultJson.get("displayName"));
			cardProductInfo.setIssuerId((String) resultJson.get("issuerId"));
			cardProductInfo.setType((String) resultJson.get("type"));
			cardProductInfo.setVersion((String) resultJson.get("version"));
			cardProductInfo.setFrontColor((String) resultJson.get("frontColor"));

			return cardProductInfo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联删除卡失败");
		}
	}

	public String getQuery_card_product_info_url() {
		return query_card_product_info_url;
	}

	@Value("#{nfcPay_config['query_card_product_info_url']}")
	public void setQuery_card_product_info_url(String query_card_product_info_url) {
		this.query_card_product_info_url = query_card_product_info_url;
	}

}
