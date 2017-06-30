/**
 * 
 */
package com.gionee.nfcPay.service.union;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;
import com.gionee.nfcPay.vo.rsp.CardEnrollClientRspVo;
import com.gionee.nfcPay.vo.rsp.CheckCardRspVo;
import com.gionee.nfcPay.vo.rsp.DeleteCardRspVo;
import com.gionee.nfcPay.vo.rsp.QueryCardEventRspVo;
import com.gionee.nfcPay.vo.rsp.QueryCardListRspVo;

/**
 * 卡信息业务操作
 * 
 * @author zhanggq
 *
 *         2017年6月20日
 */
public interface NfcUnionCardInfoService {

	/**
	 * 卡bin校验
	 * 
	 * @param vo
	 * @return
	 */
	CheckCardRspVo checkCard(ReqMsgVo vo) throws BizException;

	/**
	 * 卡申请
	 * 
	 * @param reqMsg
	 * @return
	 */
	CardEnrollClientRspVo updateCardEnroll(ReqMsgVo reqMsg, NfcUnionCoreTxnLog txn) throws BizException;

	/**
	 * 删除设备卡
	 * 
	 * @param reqMsg
	 * @return
	 */
	DeleteCardRspVo deleteCard(ReqMsgVo reqMsg) throws BizException;

	/**
	 * 轮询设备卡状态
	 * 
	 * @param reqMsg
	 * @return
	 */
	QueryCardEventRspVo queryCardEvent(ReqMsgVo reqMsg) throws BizException;

	/**
	 * @param reqMsg
	 * @return
	 */
	QueryCardListRspVo queryCardList(ReqMsgVo reqMsg) throws BizException;

}
