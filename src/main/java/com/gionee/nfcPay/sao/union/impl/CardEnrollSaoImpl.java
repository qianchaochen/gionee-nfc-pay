package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.CardEnrollSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.CardEnrollReqVo;
import com.gionee.nfcPay.vo.rsp.CardEnrollUnionRspVo;
import com.gionee.nfcPay.vo.rsp.CardMetadataVo;
import com.gionee.nfcPay.vo.rsp.VirtualCardMetadataVo;

/**
 * @author dingyw
 *
 *         2017年6月14日
 */
@Service
public class CardEnrollSaoImpl extends CommonUnionSaoImpl implements CardEnrollSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String union_card_enroll_url;

	@Override
	public CardEnrollUnionRspVo cardEnroll(CardEnrollReqVo vo) throws BizException {
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("cipheredCardInfo", vo.getCipheredCardInfo());
		jsonBody.put("tncStatus", "ACCEPTED");
		jsonBody.put("applyChannel", "01");
		jsonBody.put("riskInfo", vo.getRiskInfo());
		jsonBody.put("bankChannelData", "");
		try {

			UnionResultVo resultVo = AmigoHttpUtils.unionPost(union_card_enroll_url, jsonBody.toString(),
					super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(resultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联卡申请失败");
			}
			CardEnrollUnionRspVo cardEnrollRspVo = new CardEnrollUnionRspVo();
			JSONObject cardMetadataJson = (JSONObject) resultJson.get("cardMetadata");
			if (cardMetadataJson == null) {
				throw new BizException("卡数据元为空，请求银联卡申请失败");
			}

			CardMetadataVo cardMetadataVo = new CardMetadataVo();
			cardMetadataVo.setCardProductId(cardMetadataJson.getString("cardProductId"));
			cardMetadataVo.setCardReferenceId(cardMetadataJson.getString("cardReferenceId"));
			cardMetadataVo.setLastDigits(cardMetadataJson.getString("lastDigits"));
			cardEnrollRspVo.setCardMetadata(cardMetadataVo);

			JSONObject virtualdataJson = (JSONObject) resultJson.get("virtualCardMetadata");
			if (virtualdataJson == null) {
				throw new BizException("设备数据元为空，请求银联卡申请失败");
			}
			VirtualCardMetadataVo virtualMetadata = new VirtualCardMetadataVo();
			virtualMetadata.setVirtualCardNum(virtualdataJson.getString("virtualCardNum"));
			virtualMetadata.setVirtualCardRefId(virtualdataJson.getString("virtualCardRefId"));
			cardEnrollRspVo.setVirtualCardMetadata(virtualMetadata);
			
			cardEnrollRspVo.setTransNoDestination(resultVo.getTransNoDestination());
			cardEnrollRspVo.setTransTimeDestination(resultVo.getTransTimeDestination());

			return cardEnrollRspVo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联卡申请失败");
		}
	}

	public String getUnion_card_enroll_url() {
		return union_card_enroll_url;
	}

	@Value("#{nfcPay_config['union_card_enroll_url']}")
	public void setUnion_card_enroll_url(String union_card_enroll_url) {
		this.union_card_enroll_url = union_card_enroll_url;
	}

}
