package com.gionee.nfcPay.service.busCard.impl;

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
import com.gionee.nfcPay.dao.mapper.NfcBuscardBusiCtrlInfoTbMapper;
import com.gionee.nfcPay.dao.mapper.NfcBuscardSupportCityInfoTbMapper;
import com.gionee.nfcPay.dao.mapper.NfcBuscardUserCardInfoTbMapper;
import com.gionee.nfcPay.service.busCard.BusCardService;
import com.gionee.nfcPay.vo.models.NfcBuscardBusiCtrlInfoTb;
import com.gionee.nfcPay.vo.models.NfcBuscardSupportCityInfoTb;
import com.gionee.nfcPay.vo.models.NfcBuscardUserCardInfoTb;
import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import com.gionee.nfcPay.vo.req.busCard.OperationCtrlReqVo;
import com.gionee.nfcPay.vo.req.busCard.QuerySupportCitiesReqVo;
import com.gionee.nfcPay.vo.rsp.ClientAdviceUserActiveCardRspVo;
import com.gionee.nfcPay.vo.rsp.busCard.OperationCtrlRspVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesItemVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesRspVo;

/**
 * @author dingyw
 *
 *         2017年6月17日
 */
@Service
public class BusCardServiceImpl implements BusCardService {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	NfcBuscardSupportCityInfoTbMapper nfcBuscardSupportCityInfoTbMapper;
	@Autowired
	NfcBuscardBusiCtrlInfoTbMapper nfcBuscardBusiCtrlInfoTbMapper;
	@Autowired
	private NfcBuscardUserCardInfoTbMapper nfcBuscardUserCardInfoTbMapper;

	@Override
	public QuerySupportCitiesRspVo querySupportCities(QuerySupportCitiesReqVo vo) throws BizException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", CommonConstant.IS_VALID.TRUE.getValue());
		String orderParam = "create_time desc";

		List<QuerySupportCitiesItemVo> list = nfcBuscardSupportCityInfoTbMapper
				.selectSupportCityListByParams(params, orderParam);
		int total = nfcBuscardSupportCityInfoTbMapper.selectSupportCityListSizeByParams(params);

		try {
			for (QuerySupportCitiesItemVo cityItem : list) {
				if (StringUtils.isNotEmpty(cityItem.getAmount_list_str())) {
					cityItem.setAmount_list(cityItem.getAmount_list_str().split(","));
				}

			}
		} catch (Exception e) {
			throw new BizException("金额列表参数异常");
		}

		QuerySupportCitiesRspVo querySupportCitiesRspVo = new QuerySupportCitiesRspVo();
		querySupportCitiesRspVo.setList(list);
		querySupportCitiesRspVo.setTotal(total);
		return querySupportCitiesRspVo;
	}

	@Override
	public OperationCtrlRspVo queryOperationCtrl(OperationCtrlReqVo vo) throws BizException {

		NfcBuscardBusiCtrlInfoTb cardCtrlInfo = nfcBuscardBusiCtrlInfoTbMapper.selectByOperation(vo
				.getOperation());
		if (cardCtrlInfo == null) {
			throw new BizException("未找到相关权限");
		}

		if (!CommonConstant.IS_VALID.TRUE.getValue().equals(cardCtrlInfo.getStatus())) {
			throw new BizException("没有该权限");
		}

		OperationCtrlRspVo result = new OperationCtrlRspVo();
		return result;
	}

	@Override
	public ClientAdviceUserActiveCardRspVo insertClientAdviceUserActiveCard(ReqMsgVo reqMsg)
			throws BizException {
		log.info("reqMsgVo:" + reqMsg);

		ClientAdviceUserActiveCardReqVo vo = (ClientAdviceUserActiveCardReqVo) reqMsg.getBody();

		NfcBuscardUserCardInfoTb record = new NfcBuscardUserCardInfoTb();
		record.setxTsmCplc(vo.getxTsmCplc());
		record.setUser_id(vo.getUser_id());
		record.setPhone_no(vo.getPhone_no());
		record.setCard_no(vo.getCard_no());
		record.setAid(vo.getAid());

		Date nowDate = new Date();
		try {
			NfcBuscardSupportCityInfoTb supportCard = nfcBuscardSupportCityInfoTbMapper.selectByAid(vo
					.getAid());
			if (supportCard == null) {
				log.warn("can not find support card by aid");
			}

			if (supportCard != null) {
				record.setCard_id(supportCard.getCard_id());
				record.setCard_logo_url(supportCard.getIcon_url());
				record.setCard_product_name(supportCard.getCard_name());
				record.setCity_code(supportCard.getCity_code());
				record.setCustomer_service_tel_no(supportCard.getCustomer_service_tel());
				record.setCreate_date(nowDate);
				record.setCreate_time(nowDate);
				record.setLast_upd_time(nowDate);
			}

			nfcBuscardUserCardInfoTbMapper.insertSelective(record);
			ClientAdviceUserActiveCardRspVo result = new ClientAdviceUserActiveCardRspVo();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("重复开卡!");
		}
	}

}
