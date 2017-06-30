package com.gionee.nfcPay.service.union.notify.rcv;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.union.UnionMsgReqHeaderVo;
import com.gionee.nfcPay.vo.req.union.notify.TransResultNotifyReqVo;

public interface TransResultNotifyService {

	public void insertTransResultNotify(UnionMsgReqHeaderVo header,
			TransResultNotifyReqVo vo) throws BizException;
}
