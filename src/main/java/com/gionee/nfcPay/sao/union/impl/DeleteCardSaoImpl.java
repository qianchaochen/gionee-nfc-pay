package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.DeleteCardSao;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.DeleteCardReqVo;
import com.gionee.nfcPay.vo.rsp.DeleteCardRspVo;

/**
 * @author dingyw
 *
 *         2017年6月14日
 */
@Service
public class DeleteCardSaoImpl extends CommonUnionSaoImpl implements DeleteCardSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String union_delete_card_url;

	@Override
	public DeleteCardRspVo deleteCard(DeleteCardReqVo vo) throws BizException {
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("status", vo.getStatus());
		jsonBody.put("reason", vo.getReason());
		try {

			UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(union_delete_card_url + vo.getVirtualCardRefId(),
					jsonBody.toString(), super.getHeaderMap());
			JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
			if (resultJson == null) {
				throw new BizException("请求银联删除卡失败");
			}

			DeleteCardRspVo deleteCardRspVo = new DeleteCardRspVo();
			deleteCardRspVo.setResultCode((String) resultJson.get("resultCode"));
			deleteCardRspVo.setResultMessage((String) resultJson.get("resultMessage"));
			deleteCardRspVo.setTransNoDestination(unionResultVo.getTransNoDestination());
			deleteCardRspVo.setTransTimeDestination(unionResultVo.getTransTimeDestination());
			
			return deleteCardRspVo;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联删除卡失败");
		}
	}

	public String getUnion_delete_card_url() {
		return union_delete_card_url;
	}

	@Value("#{nfcPay_config['union_delete_card_url']}")
	public void setUnion_delete_card_url(String union_delete_card_url) {
		this.union_delete_card_url = union_delete_card_url;
	}

}
