/**
 * 
 */
package com.gionee.nfcPay.service.union;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.union.UnionMsgReqHeaderVo;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import com.gionee.nfcPay.vo.req.QueryCardListReqVo;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
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
 *         2017年6月20日
 */
public interface NfcUnionCoreTxnLogService {

	/**
	 * @param txn
	 */
	void updateTxnSucc(NfcUnionCoreTxnLog txn) throws BizException;

	/**
	 * @param txn
	 */
	void updateTxnFail(NfcUnionCoreTxnLog txn) throws BizException;

	/**
	 * @param header
	 * @param checkCardReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, CheckCardReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param checkCardReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, CardEnrollReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param checkCardReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, ApplySmsReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param checkCardReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, QueryCardListReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, PersonizeResultNotifyReqVo vo)
			throws BizException;

	/**
	 * @param header
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, BatchCardProductInfoSynNotifyReqVo vo)
			throws BizException;

	/**
	 * @param header
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header, SendTsmDataLibDataNotifyReqVo vo)
			throws BizException;

	/**
	 * @param header
	 * @param issuerInfoChangeReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header,
			CardIssuerInfoChangeNotifyReqVo issuerInfoChangeReqVo) throws BizException;

	NfcUnionCoreTxnLog tnx_init(UnionMsgReqHeaderVo header,
			CardInfoChangeNotifyReqVo cardInfoChangeNotifyReqVo) throws BizException;

	/**
	 * @param header
	 * @param cardProductinfoChangeNotifyReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header,
			CardProductInfoChangeNotifyReqVo cardProductinfoChangeNotifyReqVo) throws BizException;

	/**
	 * @param header
	 * @param cardStatusChangeNotifyVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(UnionMsgReqHeaderVo header,
			CardStatusChangeNotifyReqVo cardStatusChangeNotifyVo) throws BizException;

	/**
	 * @param header
	 * @param deleteCardReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, DeleteCardReqVo deleteCardReqVo) throws BizException;

	/**
	 * @param header
	 * @param deviceStatusChangeReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, DeviceStatusChangeReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param passwdAuthReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, PayPasswordAuthReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param queryCardEventReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, QueryCardEventReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param verifySmsReqVo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, VerifySmsReqVo vo) throws BizException;

	/**
	 * @param header
	 * @param vo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init(MsgReqHeaderVo header, ClientAdviceUserActiveCardReqVo vo) throws BizException;

	/**
	 * @param txn
	 * @param checkCardRspVo
	 */
	void txn_success(NfcUnionCoreTxnLog txn, CheckCardRspVo checkCardRspVo) throws BizException;

	/**
	 * @param txn
	 * @param applySmsRspVo
	 */
	void txn_success(NfcUnionCoreTxnLog txn, ApplySmsRspVo applySmsRspVo) throws BizException;

	/**
	 * @param txn
	 * @param deleteCardRspVo
	 */
	void txn_success(NfcUnionCoreTxnLog txn, DeleteCardRspVo deleteCardRspVo) throws BizException;

	/**
	 * @param txn
	 * @param queryCardEventRspVo
	 */
	void txn_success(NfcUnionCoreTxnLog txn, QueryCardEventRspVo queryCardEventRspVo) throws BizException;

	/**
	 * @param txn
	 * @param verifySmsRspVo
	 */
	void txn_success(NfcUnionCoreTxnLog txn, VerifySmsRspVo verifySmsRspVo) throws BizException;

	/**
	 * @param header
	 * @param vo
	 * @return
	 */
	NfcUnionCoreTxnLog txn_init (UnionMsgReqHeaderVo header,TransResultNotifyReqVo vo) throws BizException;
}
