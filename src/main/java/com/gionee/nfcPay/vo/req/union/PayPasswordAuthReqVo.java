/**
 * 
 */
package com.gionee.nfcPay.vo.req.union;


/**
 * @author zhanggq
 *
 *         2017年6月27日
 */
public class PayPasswordAuthReqVo extends BaseUnionReqVo {
	/**
	 * 金立账号的token
	 */
	private String user_token;
	/**
	 * 用户id，金立账号
	 */
	private String uid;
	/**
	 * 用户手机号
	 */
	private String phone_no;
	/**
	 * 用户密码
	 */
	private String passwd;
	/**
	 * 是否指纹支付
	 */
	private String is_fingerprint;

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getIs_fingerprint() {
		return is_fingerprint;
	}

	public void setIs_fingerprint(String is_fingerprint) {
		this.is_fingerprint = is_fingerprint;
	}

}
