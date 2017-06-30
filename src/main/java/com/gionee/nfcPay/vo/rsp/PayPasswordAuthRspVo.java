/**
 * 
 */
package com.gionee.nfcPay.vo.rsp;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author zhanggq
 *
 *         2017年6月27日
 */
public class PayPasswordAuthRspVo extends BaseMsgVo {
	/**
	 * 生成的token
	 */
	private String verify_token;

	/**
	 * 业务流水号
	 */
	private String busi_no;

	public String getVerify_token() {
		return verify_token;
	}

	public void setVerify_token(String verify_token) {
		this.verify_token = verify_token;
	}

	public String getBusi_no() {
		return busi_no;
	}

	public void setBusi_no(String busi_no) {
		this.busi_no = busi_no;
	}

}
