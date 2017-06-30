/**
 * 
 */
package com.gionee.nfcPay.service.union.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.union.UnionMsgReqHeaderVo;
import com.gionee.common.utils.DateUtils;
import com.gionee.common.utils.SeqIdSerial;
import com.gionee.nfcPay.dao.mapper.NfcUnionCoreTxnLogMapper;
import com.gionee.nfcPay.service.union.NfcUnionCoreTxnLogService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import com.gionee.nfcPay.vo.req.QueryCardListReqVo;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;
import com.gionee.nfcPay.vo.req.union.CardEnrollReqVo;
import com.gionee.nfcPay.vo.req.union.CheckCardReqVo;
import com.gionee.nfcPay.vo.req.union.DeleteCardReqVo;
import com.gionee.nfcPay.vo.req.union.DeviceStatusChangeReqVo;
import com.gionee.nfcPay.vo.req.union.PayPasswordAuthReqVo;
import com.gionee.nfcPay.vo.req.union.QueryCardEventReqVo;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.req.union.notify.BatchCardProductInfoSynNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardIssuerInfoChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardProductInfoChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.CardStatusChangeNotifyVirtualCardItemVo;
import com.gionee.nfcPay.vo.req.union.notify.PersonizeResultNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.SendTsmDataLibDataNotifyReqVo;
import com.gionee.nfcPay.vo.req.union.notify.TransResultNotifyReqVo;
import com.gionee.nfcPay.vo.rsp.ApplySmsRspVo;
import com.gionee.nfcPay.vo.rsp.CheckCardRspVo;
import com.gionee.nfcPay.vo.rsp.DeleteCardRspVo;
import com.gionee.nfcPay.vo.rsp.QueryCardEventRspVo;
import com.gionee.nfcPay.vo.rsp.VerifySmsRspVo;

/**
 * @author zhanggq
 *
 * 2017年6月20日
 */
@Service
public class NfcUnionCoreTxnLogServiceImpl implements NfcUnionCoreTxnLogService {
	@Autowired
	NfcUnionCoreTxnLogMapper nfcUnionCoreTxnLogMapper;

	@Override
	public void updateTxnSucc(NfcUnionCoreTxnLog txn) {
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.SUCCESS.getValue());
		this.updateTxn(txn);
	}

	@Override
	public void updateTxnFail(NfcUnionCoreTxnLog txn) {
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.FAILED.getValue());
		this.updateTxn(txn);
	}

	/**
	 * @param txn
	 */
	private void updateTxn(NfcUnionCoreTxnLog txn) {
		txn.setLast_upd_time(new Date());
		nfcUnionCoreTxnLogMapper.updateByPrimaryKey(txn);
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, CheckCardReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setCipheredPan(vo.getCipheredPan());
		this.txn_insert(record);
		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	/**
	 * @param record
	 */
	private void txn_insert(NfcUnionCoreTxnLog record) {
		nfcUnionCoreTxnLogMapper.insert(record);
	}

	/**
	 * @param record
	 * @param checkCardReqVo
	 * @return
	 */
	private NfcUnionCoreTxnLog setCommonVo(NfcUnionCoreTxnLog record, BaseUnionReqVo vo) {
		record.setStatus(CommonConstant.TXN_LOG_STATUS.INIT.getValue());
		record.setX_tsm_cplc(vo.getxTsmCplc());
		return record;
	}

	/**
	 * @param header
	 * @return
	 */
	private NfcUnionCoreTxnLog initCommonTxn(MsgReqHeaderVo header) {
		NfcUnionCoreTxnLog record = new NfcUnionCoreTxnLog();
		record.setInt_txn_no(SeqIdSerial.genSeqId("UNI"));
		Date date = new Date();
		record.setInt_txn_date(date);
		record.setInt_txn_time(date);

		record.setReq_version(header.getVersion());
		record.setReq_sys_code(header.getReq_sys());

		if (!StringUtils.isEmpty(header.getReq_date())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				Date req_date = sdf.parse(header.getReq_date());
				record.setReq_trans_date(req_date);
				sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date req_time = sdf.parse(header.getReq_time());
				record.setReq_trans_time(req_time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		record.setReq_trans_code(header.getTrans_code());
		record.setReq_trans_id(header.getReq_trans_id());
		record.setReq_channel(header.getReq_channel());
		record.setUa(header.getUa());
		record.setLast_upd_time(date);
		record.setCreate_time(date);
		record.setCreate_date(date);
		return record;
	}

	/**
	 * @param header
	 * @return
	 */
	private NfcUnionCoreTxnLog initCommonTxn(UnionMsgReqHeaderVo header) {
		NfcUnionCoreTxnLog record = new NfcUnionCoreTxnLog();
		record.setInt_txn_no(SeqIdSerial.genSeqId("UNI"));
		Date date = new Date();
		record.setInt_txn_date(date);
		record.setInt_txn_time(date);

		record.setReq_version("1.0.0");
		record.setReq_sys_code(CommonConstant.COMMON_SYS_CODE.UNION_PAY.getValue());

		if (!StringUtils.isEmpty(header.getTransTimeSource())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			try {
				Date req_time = sdf.parse(header.getTransTimeSource());
				record.setReq_trans_date(req_time);
				record.setReq_trans_time(req_time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		record.setReq_trans_code(header.getTrans_code());
		record.setReq_trans_id(header.getTransNoSource());

		record.setLast_upd_time(date);
		record.setCreate_time(date);
		record.setCreate_date(date);
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, PersonizeResultNotifyReqVo vo)
			throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setPersonize_status(vo.getStatus());
		record.setVirtualCardRefId(vo.getVirtualCardRefId());
		record.setAid(vo.getAid());
		this.txn_insert(record);

		return record;
	}

	@Override
	public NfcUnionCoreTxnLog tnx_init(UnionMsgReqHeaderVo header, CardInfoChangeNotifyReqVo vo)
			throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());
		record.setCardReferenceId(vo.getCardReferenceId());
		record.setCardProductId(vo.getCardProductId());
		record.setLastDigits(vo.getLastDigits());
		record.setCardInfoChangeTaskId(vo.getTaskId());
		this.txn_insert(record);
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header,
			CardIssuerInfoChangeNotifyReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);

		record.setIssuerId(vo.getIssuerId());
		record.setIssuer_version(vo.getVersion());

		this.txn_insert(record);

		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, CardProductInfoChangeNotifyReqVo vo)
			throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);

		record.setCardProductId(vo.getCardProductId());
		record.setIssuerId(vo.getIssuerId());
		record.setIssuer_version(vo.getVersion());

		this.txn_insert(record);

		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, CardStatusChangeNotifyReqVo vo)
			throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);

		StringBuilder statusSb = new StringBuilder();
		StringBuilder virtualRefIdSb = new StringBuilder();
		List<CardStatusChangeNotifyVirtualCardItemVo> virtualCards = vo.getVirtualCards();
		for (CardStatusChangeNotifyVirtualCardItemVo item : virtualCards) {
			statusSb.append(item.getStatus()).append(",");
			virtualRefIdSb.append(item.getVirtualCardRefId()).append(",");
		}

		record.setRcv_rsp_desc(statusSb.toString() + virtualRefIdSb.toString());

		this.txn_insert(record);

		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, SendTsmDataLibDataNotifyReqVo vo)
			throws BizException {
		// 公共部分
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);

		// 每个Vo不同部分
		if (vo.getVirtualCards() != null && vo.getVirtualCards().size() != 0) {
			record.setVirtualCards(vo.getVirtualCards().toString());
		}

		if (vo.getTsmLibData() != null) {
			record.setTsmLibData(vo.getTsmLibData().toString());
		}

		this.txn_insert(record);
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, BatchCardProductInfoSynNotifyReqVo vo)
			throws BizException {
		// 公共部分
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);

		// 每个Vo不同部分
		if (vo.getCardProductList() != null && vo.getCardProductList().size() != 0) {
			if (vo.getCardProductList().toString().length() <= 256)
				record.setCardProductId(vo.getCardProductList().toString());
			else {
				record.setCardProductId(vo.getCardProductList().toString().substring(0, 255)); // 只保留256长度
			}
		}
		this.txn_insert(record);
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, QueryCardListReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setUser_id(vo.getUser_id());
		record.setPhone_no(vo.getPhone_no());

		this.txn_insert(record);
		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, ApplySmsReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, CardEnrollReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setUser_id(vo.getUser_id());
		record.setPhone_no(vo.getPhone_no());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, DeleteCardReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());
		record.setCard_status_change_reason(vo.getReason());
		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, DeviceStatusChangeReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setX_tsm_cplc(vo.getSecureElement());
		record.setDevice_status_event(vo.getEvent());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, PayPasswordAuthReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setUser_id(vo.getUid());
		record.setPhone_no(vo.getPhone_no());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, QueryCardEventReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, VerifySmsReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, ClientAdviceUserActiveCardReqVo vo)
			throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record = this.setCommonVo(record, vo);
		record.setUser_id(vo.getUser_id());
		record.setPhone_no(vo.getPhone_no());
		record.setAid(vo.getAid());
		record.setVirtualCardNum(vo.getCard_no());

		this.txn_insert(record);

		vo.setTransNoSource(record.getInt_txn_no());// 设置交易流水号
		return record;
	}

	@Override
	public void txn_success(NfcUnionCoreTxnLog txn, CheckCardRspVo resultVo) throws BizException {
		if(resultVo == null) {
			this.updateTxnSucc(txn);
			return;
		}
		txn.setRcv_trans_date(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_time(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_id(resultVo.getTransNoDestination());
		txn.setIssuerId(resultVo.getIssuerId());
		txn.setReq_trans_back_rsp_desc(resultVo.getCardType());
		this.updateTxnSucc(txn);
	}

	@Override
	public void txn_success(NfcUnionCoreTxnLog txn, ApplySmsRspVo applySmsRspVo) throws BizException {
		txn.setRcv_trans_date(DateUtils.getParseTime(applySmsRspVo.getTransTimeDestination()));
		txn.setRcv_trans_time(DateUtils.getParseTime(applySmsRspVo.getTransTimeDestination()));
		txn.setRcv_trans_id(applySmsRspVo.getTransNoDestination());
		txn.setRcv_rsp_desc(applySmsRspVo.getExpirationDate());
		txn.setReq_trans_back_rsp_desc("响应过期时间为：" + applySmsRspVo.getExpirationDate());
		this.updateTxnSucc(txn);
	}

	@Override
	public void txn_success(NfcUnionCoreTxnLog txn, DeleteCardRspVo resultVo) throws BizException {
		if(resultVo == null) {
			this.updateTxnSucc(txn);
			return;
		}
		txn.setRcv_trans_date(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_time(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_id(resultVo.getTransNoDestination());
		txn.setRcv_rsp_code(resultVo.getResultCode());
		txn.setRcv_rsp_desc(resultVo.getResultMessage());
		txn.setRcv_trans_time(DateUtils.getParseTime(resultVo.getSubmitTime()));
		this.updateTxnSucc(txn);
	}

	@Override
	public void txn_success(NfcUnionCoreTxnLog txn, QueryCardEventRspVo resultVo) throws BizException {
		if(resultVo == null) {
			this.updateTxnSucc(txn);
			return;
		}
		txn.setReq_trans_back_rsp_code("0000");
		txn.setReq_trans_back_date(new Date());
		txn.setReq_trans_back_rsp_desc("tsm_event:" + resultVo.getTsm_event() + ",tsm_ssid:"
				+ resultVo.getSsid() + ",tsm_sign:" + resultVo.getSign() + ",aid:" + resultVo.getAid());

		this.updateTxnSucc(txn);

	}

	@Override
	public void txn_success(NfcUnionCoreTxnLog txn, VerifySmsRspVo resultVo) throws BizException {
		if(resultVo == null) {
			this.updateTxnSucc(txn);
			return;
		}
		txn.setRcv_trans_date(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_time(DateUtils.getParseTime(resultVo.getTransTimeDestination()));
		txn.setRcv_trans_id(resultVo.getTransNoDestination());
		txn.setReq_trans_back_rsp_desc(resultVo.getVerifyResult());
		this.updateTxnSucc(txn);
	}
	
	@Override
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header,
			TransResultNotifyReqVo vo) throws BizException {
		NfcUnionCoreTxnLog record = this.initCommonTxn(header);
		record.setInt_txn_no(SeqIdSerial.genSeqId("UNI"));
		record=this.setCommonVo(record, vo);
		record.setVirtualCardRefId(vo.getVirtualCardRefId());
		this.txn_insert(record);
		
		return record;
	}

}
