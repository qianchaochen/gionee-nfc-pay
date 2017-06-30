/**
 * 
 */
package com.gionee.nfcPay.service.union.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.utils.DateUtils;
import com.gionee.nfcPay.dao.mapper.NfcBuscardSupportCityInfoTbMapper;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardInfoTbMapper;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardIssuerInfoTbMapper;
import com.gionee.nfcPay.dao.mapper.NfcUnionCardProductInfoTbMapper;
import com.gionee.nfcPay.sao.union.CardEnrollSao;
import com.gionee.nfcPay.sao.union.CheckCardSao;
import com.gionee.nfcPay.sao.union.DeleteCardSao;
import com.gionee.nfcPay.service.union.NfcUnionCardInfoService;
import com.gionee.nfcPay.vo.models.NfcUnionCardInfoTb;
import com.gionee.nfcPay.vo.models.NfcUnionCardIssuerInfoTb;
import com.gionee.nfcPay.vo.models.NfcUnionCardProductInfoTb;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.QueryCardListReqVo;
import com.gionee.nfcPay.vo.req.union.CardEnrollReqVo;
import com.gionee.nfcPay.vo.req.union.CheckCardReqVo;
import com.gionee.nfcPay.vo.req.union.DeleteCardReqVo;
import com.gionee.nfcPay.vo.req.union.QueryCardEventReqVo;
import com.gionee.nfcPay.vo.rsp.CardEnrollClientRspVo;
import com.gionee.nfcPay.vo.rsp.CardEnrollUnionRspVo;
import com.gionee.nfcPay.vo.rsp.CardMetadataVo;
import com.gionee.nfcPay.vo.rsp.CheckCardRspVo;
import com.gionee.nfcPay.vo.rsp.DeleteCardRspVo;
import com.gionee.nfcPay.vo.rsp.QueryCardEventRspVo;
import com.gionee.nfcPay.vo.rsp.QueryCardListItemVo;
import com.gionee.nfcPay.vo.rsp.QueryCardListRspVo;
import com.gionee.nfcPay.vo.rsp.VirtualCardMetadataVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesItemVo;

/**
 * @author zhanggq
 *
 *         2017年6月20日
 */
@Service
public class NfcUnionCardInfoServiceImpl implements NfcUnionCardInfoService {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private CheckCardSao checkCardSao;
	@Autowired
	private CardEnrollSao cardEnrollSao;
	@Autowired
	private DeleteCardSao deleteCardSao;
	@Autowired
	private NfcUnionCardInfoTbMapper nfcUnionCardInfoTbMapper;
	@Autowired
	private NfcUnionCardIssuerInfoTbMapper nfcUnionCardIssuerInfoMapper;
	@Autowired
	private NfcUnionCardProductInfoTbMapper nfcUnionCardProductInfoTbMapper;
	@Autowired
	NfcBuscardSupportCityInfoTbMapper nfcBuscardSupportCityInfoTbMapper;

	@Override
	public CheckCardRspVo checkCard(ReqMsgVo reqMsgVo) throws BizException {
		log.info("reqMsgVo->" + reqMsgVo);
		try {

			CheckCardReqVo checkCardReqVo = (CheckCardReqVo) reqMsgVo.getBody();
			// 设置返回参数
			CheckCardRspVo result = checkCardSao.checkCard(checkCardReqVo);
			if (StringUtils.isEmpty(result.getIssuerId())) {
				return result;
			}
			
			log.info("checkCardSao result:" + result);

			// 查询发卡行信息表，补全发卡行信息返回
			NfcUnionCardIssuerInfoTb cardIssuerInfo = nfcUnionCardIssuerInfoMapper.selectByPrimaryKey(result
					.getIssuerId());
			if (cardIssuerInfo == null) {
				return result;
			}

			result.setName(cardIssuerInfo.getName());
			result.setDescription(cardIssuerInfo.getDescription());
			result.setLogo(cardIssuerInfo.getLogo());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("卡bin校验失败");
		}
	}

	@Override
	public CardEnrollClientRspVo updateCardEnroll(ReqMsgVo reqMsg, NfcUnionCoreTxnLog txn)
			throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			CardEnrollReqVo vo = (CardEnrollReqVo) reqMsg.getBody();
			// 银联卡申请返回参数
			CardEnrollUnionRspVo unionRspVo = cardEnrollSao.cardEnroll(vo);
			if (unionRspVo == null) {
				throw new BizException("卡申请失败");
			}
			
			log.info("cardEnrollSao result:" + unionRspVo);
			// 卡信息入库
			NfcUnionCardInfoTb cardRecord = buildCardInfo(unionRspVo, vo);

			nfcUnionCardInfoTbMapper.insertSelective(cardRecord);

			unionRspVo.setSubmitTime(DateUtils.getFormatSubmitTime(cardRecord.getLast_update_time()));

			CardEnrollClientRspVo result = new CardEnrollClientRspVo();
			result.setVirtualCardRefId(cardRecord.getVirtualCardRefId());
			result.setVirtualCardNum(cardRecord.getVirtualCardNum());
			result.setSubmitTime(unionRspVo.getSubmitTime());
			result.setLastDigits(cardRecord.getLastDigits());
			result.setCardReferenceId(cardRecord.getCardReferenceId());
			result.setCardProductId(cardRecord.getCardProductId());

			NfcUnionCardProductInfoTb cardProductInfo = nfcUnionCardProductInfoTbMapper
					.selectByPrimaryKey(cardRecord.getCardProductId());
			if (cardProductInfo != null) {
				result.setCard_logo_url(cardProductInfo.getCardArt());
			}

			assembleRcvParams(txn, unionRspVo, result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("卡申请失败");
		}
	}

	private void assembleRcvParams(NfcUnionCoreTxnLog txn, CardEnrollUnionRspVo cardEnrollUnionRspVo,
			CardEnrollClientRspVo result) throws BizException {
		txn.setRcv_trans_date(DateUtils.getParseTime(cardEnrollUnionRspVo.getTransTimeDestination()));
		txn.setRcv_trans_time(DateUtils.getParseTime(cardEnrollUnionRspVo.getTransTimeDestination()));
		txn.setRcv_trans_id(cardEnrollUnionRspVo.getTransNoDestination());

		txn.setCardReferenceId(result.getCardReferenceId());
		txn.setCardProductId(result.getCardProductId());
		txn.setLastDigits(result.getLastDigits());
		txn.setVirtualCardRefId(result.getVirtualCardRefId());
		txn.setVirtualCardNum(result.getVirtualCardNum());
		txn.setRcv_rsp_desc(result.getCard_logo_url());
		txn.setReq_trans_back_time(DateUtils.getParseTime(result.getSubmitTime()));
	}

	/**
	 * @param result
	 * @param vo
	 * @throws BizException
	 */
	private NfcUnionCardInfoTb buildCardInfo(CardEnrollUnionRspVo result, CardEnrollReqVo vo)
			throws BizException {
		NfcUnionCardInfoTb cardRecord = new NfcUnionCardInfoTb();

		CardMetadataVo cardMetadataVo = result.getCardMetadata();
		if (cardMetadataVo == null) {
			throw new BizException("卡申请卡数据元不能为空");
		}
		cardRecord.setCardReferenceId(cardMetadataVo.getCardReferenceId());
		cardRecord.setCardProductId(cardMetadataVo.getCardProductId());
		cardRecord.setLastDigits(cardMetadataVo.getLastDigits());

		VirtualCardMetadataVo virtualDataVo = result.getVirtualCardMetadata();
		if (virtualDataVo == null) {
			throw new BizException("卡申请设备卡元数据不能为空");
		}

		cardRecord.setVirtualCardNum(virtualDataVo.getVirtualCardNum());
		cardRecord.setVirtualCardRefId(virtualDataVo.getVirtualCardRefId());
		Date nowTime = new Date();
		cardRecord.setCreate_date(nowTime);
		cardRecord.setCreate_time(nowTime);
		cardRecord.setLast_update_time(nowTime);
		cardRecord.setPhone_no(vo.getPhone_no());
		cardRecord.setUser_id(vo.getUser_id());
		cardRecord.setStatus(CommonConstant.NFC_UNION_CARD_STATUS.INITIAL.getValue());
		cardRecord.setxTsmCplc(vo.getxTsmCplc());

		return cardRecord;
	}

	@Override
	public DeleteCardRspVo deleteCard(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			DeleteCardReqVo vo = (DeleteCardReqVo) reqMsg.getBody();
			// 设置返回参数
			DeleteCardRspVo result = deleteCardSao.deleteCard(vo);
			if (result == null) {
				throw new BizException("卡删除失败");
			}

			log.info("deleteCardSao result:" + result);
			
			Date updateTime = new Date();
			// 卡删除成功，更新数据库卡状态
			if (CommonConstant.UNION_DELETE_CARD_RESULT_CODE.SUCCESS.getValue()
					.equals(result.getResultCode())) {
				NfcUnionCardInfoTb deleteCard = new NfcUnionCardInfoTb();
				deleteCard.setStatus(CommonConstant.NFC_UNION_CARD_STATUS.DELETED.getValue());
				deleteCard.setLast_update_time(updateTime);
				nfcUnionCardInfoTbMapper.updateByPrimaryKeySelective(deleteCard);
			} else {
				throw new BizException("卡删除失败");
			}

			result.setSubmitTime(DateUtils.getFormatSubmitTime(updateTime));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("卡删除失败");
		}
	}

	@Override
	public QueryCardEventRspVo queryCardEvent(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			QueryCardEventReqVo vo = (QueryCardEventReqVo) reqMsg.getBody();

			NfcUnionCardInfoTb cardInfo = nfcUnionCardInfoTbMapper.selectCardNewTsmEvent(
					vo.getVirtualCardRefId(), vo.getSubmitTime());
			if (cardInfo == null) {
				return null;
			}
			log.info("queryCardEvent:{}", cardInfo);
			QueryCardEventRspVo result = new QueryCardEventRspVo();
			result.setSsid(cardInfo.getTsm_ssid());
			result.setSign(cardInfo.getTsm_sign());
			result.setTsm_event(cardInfo.getTsm_event());
			result.setAid(cardInfo.getAid());

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("轮询设备卡失败");
		}
	}

	@Override
	public QueryCardListRspVo queryCardList(ReqMsgVo reqMsg) throws BizException {
		log.info("reqMsgVo->" + reqMsg);
		try {

			QueryCardListReqVo vo = (QueryCardListReqVo) reqMsg.getBody();

			List<QueryCardListItemVo> cardList = nfcUnionCardInfoTbMapper.selectBusCardUnionCardList(vo
					.getUser_id());
			int total = nfcUnionCardInfoTbMapper.selectBusCardUnionCardListSize(vo.getUser_id());

			QueryCardListRspVo result = new QueryCardListRspVo();
			result.setList(cardList);
			result.setTotal(total);
			result.setBus_card_list(querySupportCities());

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("查询卡包列表失败");
		}
	}
	
	public List<QuerySupportCitiesItemVo>  querySupportCities() throws BizException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", CommonConstant.IS_VALID.TRUE.getValue());
		String orderParam = "create_time desc";

		List<QuerySupportCitiesItemVo> list = nfcBuscardSupportCityInfoTbMapper
				.selectSupportCityListByParams(params, orderParam);
		
		try{
			for(QuerySupportCitiesItemVo cityItem: list) {
				if(StringUtils.isNotEmpty(cityItem.getAmount_list_str())) {
					cityItem.setAmount_list(cityItem.getAmount_list_str().split(","));
				}
				
			}
		}catch(Exception e) {
			throw new BizException("查询支持的公交卡列表失败");
		}
		
		return list;
	}
}
