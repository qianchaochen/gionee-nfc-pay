/**
 * 
 */
package com.gionee.nfcPay.vo.req;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author zhanggq
 *
 *         2017年6月24日
 */
public class QueryCardListReqVo extends BaseUnionReqVo {
	/**
	 * 用户账号
	 */
	private String user_id;

	/**
	 * 手机号
	 */
	private String phone_no;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}
