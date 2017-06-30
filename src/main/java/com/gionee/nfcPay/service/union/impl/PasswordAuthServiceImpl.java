/**
 * 
 */
package com.gionee.nfcPay.service.union.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.nfcPay.sao.pay.PasswordAuthSao;
import com.gionee.nfcPay.service.union.PasswordAuthService;
import com.gionee.nfcPay.vo.req.union.PayPasswordAuthReqVo;
import com.gionee.nfcPay.vo.rsp.PayPasswordAuthRspVo;

/**
 * @author zhanggq
 *
 * 2017年6月27日
 */
@Service
public class PasswordAuthServiceImpl implements PasswordAuthService{
	@Autowired
	PasswordAuthSao passwordAuthSao;
	
	@Override
	public PayPasswordAuthRspVo authPasswd(ReqMsgVo reqMsg) throws BizException {
		PayPasswordAuthReqVo passwdAuthReqVo = (PayPasswordAuthReqVo) reqMsg.getBody();
		passwdAuthReqVo.setUser_token(reqMsg.getHeader().getUser_token());
		
		PayPasswordAuthRspVo passwdAuthRsp = passwordAuthSao.authPasswd(passwdAuthReqVo);
		return passwdAuthRsp;
	}

}
