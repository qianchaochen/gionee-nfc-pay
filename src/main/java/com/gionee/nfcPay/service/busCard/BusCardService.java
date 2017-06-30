package com.gionee.nfcPay.service.busCard;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.vo.req.busCard.OperationCtrlReqVo;
import com.gionee.nfcPay.vo.req.busCard.QuerySupportCitiesReqVo;
import com.gionee.nfcPay.vo.rsp.ClientAdviceUserActiveCardRspVo;
import com.gionee.nfcPay.vo.rsp.busCard.OperationCtrlRspVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesRspVo;

/**
 * @author dingyw
 *
 * 2017年6月17日
 */
public interface BusCardService {
	
	/**
	 * @param vo
	 * @return
	 */
	public QuerySupportCitiesRspVo querySupportCities(QuerySupportCitiesReqVo vo)throws BizException;

	/**
	 * @param vo
	 * @return
	 */
	public OperationCtrlRspVo queryOperationCtrl(OperationCtrlReqVo vo) throws BizException;

	/**
	 * @param reqMsgVo
	 * @return
	 */
	public ClientAdviceUserActiveCardRspVo insertClientAdviceUserActiveCard(ReqMsgVo reqMsgVo) throws BizException;

}
