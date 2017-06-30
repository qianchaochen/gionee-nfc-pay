package com.gionee.nfcPay.service.union.notify.rcv.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.union.UnionMsgReqHeaderVo;
import com.gionee.nfcPay.dao.mapper.NfcUnionTransResultNotifyTbMapper;
import com.gionee.nfcPay.service.union.notify.rcv.TransResultNotifyService;
import com.gionee.nfcPay.vo.models.NfcUnionTransResultNotifyTb;
import com.gionee.nfcPay.vo.req.union.notify.TransResultNotifyReqVo;

@Service
public class TransResultNotifyServiceImpl implements TransResultNotifyService{
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NfcUnionTransResultNotifyTbMapper nfcUnionTransResultNotifyTbMapper;

	
	@Override
	public void insertTransResultNotify(UnionMsgReqHeaderVo header,
			TransResultNotifyReqVo vo) throws BizException {
		NfcUnionTransResultNotifyTb record = new NfcUnionTransResultNotifyTb();
		record.setVirtualCardRefId(vo.getVirtualCardRefId());
		record.setTransactionId(vo.getTransactionId());
		record.setTransactionType(vo.getTransactionType());
		record.setApprovalDateTime(vo.getApprovalDateTime());
		record.setTransactionStatus(vo.getTransactionStatus());
		record.setPaymentMethod(vo.getPaymentMethod());
		record.setTransTimeSource(header.getTransTimeSource());
		record.setTransNoSource(header.getTransNoSource());

		try {
			nfcUnionTransResultNotifyTbMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new BizException("交易结果通知失败");
		}

	}

}
