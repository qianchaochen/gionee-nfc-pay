package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.CheckCardSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.CheckCardReqVo;
import com.gionee.nfcPay.vo.rsp.CheckCardRspVo;

/**
 * @author dingyw
 *
 *         2017年6月13日
 */
@Service
public class CheckCardSaoImpl extends CommonUnionSaoImpl implements CheckCardSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String union_check_card_url;

	@Override
	public CheckCardRspVo checkCard(CheckCardReqVo vo) throws BizException {
		super.setHeaderMap(vo);
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("cipheredPan", vo.getCipheredPan());
		try {

			UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(union_check_card_url, jsonBody.toString(),
					super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联校验卡bin失败");
			}
			CheckCardRspVo checkCardRspVo = new CheckCardRspVo();
			checkCardRspVo.setCardType((String) resultJson.get("cardType"));
			checkCardRspVo.setIssuerId((String) resultJson.get("issuerId"));
			checkCardRspVo.setTransNoDestination(unionResultVo.getTransNoDestination());
			checkCardRspVo.setTransTimeDestination(unionResultVo.getTransTimeDestination());
			
			return checkCardRspVo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联校验卡bin失败");
		}
	}

	public String getUnion_check_card_url() {
		return union_check_card_url;
	}

	@Value("#{nfcPay_config['union_check_card_url']}")
	public void setUnion_check_card_url(String union_check_card_url) {
		this.union_check_card_url = union_check_card_url;
	}

}
