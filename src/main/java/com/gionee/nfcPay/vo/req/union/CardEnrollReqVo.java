package com.gionee.nfcPay.vo.req.union;

/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class CardEnrollReqVo extends BaseUnionReqVo{
	
	/**
	 * 加密后的银行卡信息
	 * 复合域
	 */
	private CipheredCardInfoVo cipheredCardInfo;
	
	/**
	 * 风控字段
	 * 复合域：RiskInfo
	 */
	private RiskInfoVo riskInfo;
	
	/**
	 * 用户账号
	 */
	private String user_id;
	
	/**
	 * 用户手机号
	 */
	private String phone_no;

	public CipheredCardInfoVo getCipheredCardInfo() {
		return cipheredCardInfo;
	}

	public void setCipheredCardInfo(CipheredCardInfoVo cipheredCardInfo) {
		this.cipheredCardInfo = cipheredCardInfo;
	}

	public RiskInfoVo getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(RiskInfoVo riskInfo) {
		this.riskInfo = riskInfo;
	}

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
