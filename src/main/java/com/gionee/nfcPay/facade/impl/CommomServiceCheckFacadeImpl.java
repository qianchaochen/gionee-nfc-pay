/**
 * 
 */
package com.gionee.nfcPay.facade.impl;

import com.gionee.nfcPay.vo.req.ClientAdviceUserActiveCardReqVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.nfcPay.facade.CommomServiceCheckFacade;
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
 * @author zhanggq
 *
 *         2017年6月20日
 */
@Service
public class CommomServiceCheckFacadeImpl implements CommomServiceCheckFacade {

	@Override
	public void commonCheck(MsgReqHeaderVo header) throws BizException {
		if (StringUtils.isEmpty(header.getTrans_code()) || StringUtils.isEmpty(header.getReq_sys())
				|| StringUtils.isEmpty(header.getReq_date()) || StringUtils.isEmpty(header.getReq_time())
				|| StringUtils.isEmpty(header.getVersion())) {
			throw new BizException("header参数异常");
		}
	}

	@Override
	public void checkUserToken(MsgReqHeaderVo header) throws BizException {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkCardReqVo(CheckCardReqVo checkCardReqVo) throws BizException {
		if (StringUtils.isEmpty(checkCardReqVo.getxTsmCplc())) {
			throw new BizException("CPLC不能为空");
		}

		if (StringUtils.isEmpty(checkCardReqVo.getCipheredPan())) {
			throw new BizException("加密实体卡号不能为空");
		}

	}

	@Override
	public void checkCardEnrollReqVo(CardEnrollReqVo cardEnrollReqVo) throws BizException {
		if (StringUtils.isEmpty(cardEnrollReqVo.getxTsmCplc())) {
			throw new BizException("CPLC不能为空");
		}

		if (StringUtils.isEmpty(cardEnrollReqVo.getUser_id())) {
			throw new BizException("账号不能为空");
		}

		if (cardEnrollReqVo.getCipheredCardInfo() == null) {
			throw new BizException("cardInfo不能为空");
		}

		if (cardEnrollReqVo.getRiskInfo() == null) {
			throw new BizException("riskInfo不能为空");
		}
	}

	@Override
	public void checkApplySms(ApplySmsReqVo applySmsReqVo) throws BizException {
		if (StringUtils.isEmpty(applySmsReqVo.getxTsmCplc())) {
			throw new BizException("CPLC不能为空");
		}
		if (StringUtils.isEmpty(applySmsReqVo.getVirtualCardRefId())) {
			throw new BizException("设备卡PAN别名不能为空");
		}

	}

	@Override
	public void checkVerifySmsReqVo(VerifySmsReqVo verifySmsReqVo) throws BizException {
		if (StringUtils.isEmpty(verifySmsReqVo.getxTsmCplc())) {
			throw new BizException("CPLC不能为空");
		}
		if (StringUtils.isEmpty(verifySmsReqVo.getVirtualCardRefId())) {
			throw new BizException("设备卡PAN别名不能为空");
		}
		if (StringUtils.isEmpty(verifySmsReqVo.getOtpValue())) {
			throw new BizException("短信验证码不能为空");
		}

	}

	@Override
	public void checkDeleteCardReqVo(DeleteCardReqVo deleteCardReqVo) throws BizException {
		if (StringUtils.isEmpty(deleteCardReqVo.getReason())) {
			throw new BizException("设备卡删除原因不能为空");
		}
		if (StringUtils.isEmpty(deleteCardReqVo.getVirtualCardRefId())) {
			throw new BizException("设备卡PAN别名不能为空");
		}
	}

	@Override
	public void checkQueryCardEventReqVo(QueryCardEventReqVo queryCardEventReqVo) throws BizException {
		if (StringUtils.isEmpty(queryCardEventReqVo.getSubmitTime())) {
			throw new BizException("请求时间不能为空");
		}
		if (StringUtils.isEmpty(queryCardEventReqVo.getVirtualCardRefId())) {
			throw new BizException("设备卡PAN别名不能为空");
		}
	}

	@Override
	public void checkQueryCardListReqVo(QueryCardListReqVo queryCardListReqVo) throws BizException {
		if (StringUtils.isEmpty(queryCardListReqVo.getUser_id())
				|| StringUtils.isEmpty(queryCardListReqVo.getPhone_no())) {
			throw new BizException("参数不能为空");
		}
	}

	@Override
	public void checkPasswdAuthReqVo(PayPasswordAuthReqVo passwdAuthReqVo) throws BizException {
		if (StringUtils.isEmpty(passwdAuthReqVo.getUid()) || StringUtils.isEmpty(passwdAuthReqVo.getPasswd())
				|| StringUtils.isEmpty(passwdAuthReqVo.getIs_fingerprint())) {
			throw new BizException("参数不能为空");
		}

	}

    @Override
    public void checkClientAdviceUserActiveCardReqVo(ClientAdviceUserActiveCardReqVo clientAdviceUserActiveCardReqVo) throws BizException {
        if (StringUtils.isEmpty(clientAdviceUserActiveCardReqVo.getxTsmCplc())) {
            throw new BizException("CPLC不能为空");
        }
        if (StringUtils.isEmpty(clientAdviceUserActiveCardReqVo.getUser_id())
                || StringUtils.isEmpty(clientAdviceUserActiveCardReqVo.getPhone_no())) {
            throw new BizException("实体卡号和手机号不能为空");
        }
    }

	@Override
	public void checkTransResultNotifyReqVo(
			TransResultNotifyReqVo transResultNotifyReqVo) throws BizException {

		if (StringUtils.isEmpty(transResultNotifyReqVo.getVirtualCardRefId())) {
			throw new BizException("设备卡PAN别名不能为空");
		}
		if (StringUtils.isEmpty(transResultNotifyReqVo.getTransactionId())) {
			throw new BizException("交易ID不能为空");
		}
		if (StringUtils.isEmpty(transResultNotifyReqVo.getTransactionType())) {
			throw new BizException("交易类型不能为空");
		}
		if (StringUtils.isEmpty(transResultNotifyReqVo.getApprovalDateTime())) {
			throw new BizException("交易日期不能为空");
		}
		if (StringUtils.isEmpty(transResultNotifyReqVo.getTransactionStatus())) {
			throw new BizException("交易状态不能为空");
		}
		if (StringUtils.isEmpty(transResultNotifyReqVo.getPaymentMethod())) {
			throw new BizException("支付方式不能为空");
		}
		
	}

}
