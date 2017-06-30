/**
 * 
 */
package com.gionee.nfcPay.facade;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import com.gionee.nfcPay.vo.req.QueryCardListReqVo;
import com.gionee.nfcPay.vo.req.union.ApplySmsReqVo;
import com.gionee.nfcPay.vo.req.union.CardEnrollReqVo;
import com.gionee.nfcPay.vo.req.union.CheckCardReqVo;
import com.gionee.nfcPay.vo.req.union.DeleteCardReqVo;
import com.gionee.nfcPay.vo.req.union.PayPasswordAuthReqVo;
import com.gionee.nfcPay.vo.req.union.QueryCardEventReqVo;
import com.gionee.nfcPay.vo.req.union.VerifySmsReqVo;
import com.gionee.nfcPay.vo.req.union.notify.TransResultNotifyReqVo;

/**
 * 校验业务层
 * @author zhanggq
 *
 * 2017年6月20日
 */
public interface CommomServiceCheckFacade {

	/**
	 * @param header
	 */
	void commonCheck(MsgReqHeaderVo header) throws BizException;

	/**
	 * @param header
	 */
	void checkUserToken(MsgReqHeaderVo header) throws BizException;

	/**
	 * @param checkCardReqVo
	 */
	void checkCardReqVo(CheckCardReqVo checkCardReqVo) throws BizException;

	/**
	 * @param cardEnrollReqVo
	 */
	void checkCardEnrollReqVo(CardEnrollReqVo cardEnrollReqVo) throws BizException;

	/**
	 * @param applySmsReqVo
	 */
	void checkApplySms(ApplySmsReqVo applySmsReqVo) throws BizException;

	/**
	 * @param verifySmsReqVo
	 */
	void checkVerifySmsReqVo(VerifySmsReqVo verifySmsReqVo) throws BizException;

	/**
	 * @param deleteCardReqVo
	 */
	void checkDeleteCardReqVo(DeleteCardReqVo deleteCardReqVo) throws BizException;

	/**
	 * @param queryCardEventReqVo
	 */
	void checkQueryCardEventReqVo(QueryCardEventReqVo queryCardEventReqVo) throws BizException;

	/**
	 * @param queryCardListReqVo
	 */
	void checkQueryCardListReqVo(QueryCardListReqVo queryCardListReqVo) throws BizException;

	/**
	 * @param passwdAuthReqVo
	 */
	void checkPasswdAuthReqVo(PayPasswordAuthReqVo passwdAuthReqVo) throws BizException;

	/**
	 * @param clientAdviceUserActiveCardReqVo
     */
	void checkClientAdviceUserActiveCardReqVo(ClientAdviceUserActiveCardReqVo clientAdviceUserActiveCardReqVo) throws BizException;

	/**
	 * @param transResultNotifyReqVo
	 */
	void checkTransResultNotifyReqVo(TransResultNotifyReqVo transResultNotifyReqVo) throws BizException;
}
