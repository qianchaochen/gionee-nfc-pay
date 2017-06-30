package com.gionee.common.msg;

import com.gionee.common.vo.BaseMsgVo;


/**
 * @author dingyw
 *
 * 报文体公共信息
 * 2015年1月21日
 */
public class MsgReqHeaderVo extends BaseMsgVo{
	private String 	user_token	;//	账号信令
	private String 	access_token	;//	支付信令
	private String 	trans_code	;//	交易代码
	private String 	req_sys	;//	发起方系统
	private String 	req_channel	;//	发起方渠道
	private String 	req_date	;//	交易日期
	private String 	req_time	;//	发起时间
	private String 	imei	;//	手机imei
	private String 	version	;//	客户端版本号
	private String 	ua	;//	手机ua参数
	private String  req_trans_id;//强制生成req_trans_id，用来区分每笔不同的交易
	private String  sign; //签名
	private String  body;//报文体
	
	private String ip;//ip信息
	
	public String getUser_token() {
		return user_token;
	}
	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getReq_sys() {
		return req_sys;
	}
	public void setReq_sys(String req_sys) {
		this.req_sys = req_sys;
	}
	public String getReq_channel() {
		return req_channel;
	}
	public void setReq_channel(String req_channel) {
		this.req_channel = req_channel;
	}
	public String getReq_date() {
		return req_date;
	}
	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}
	public String getReq_time() {
		return req_time;
	}
	public void setReq_time(String req_time) {
		this.req_time = req_time;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getReq_trans_id() {
		return req_trans_id;
	}
	public void setReq_trans_id(String req_trans_id) {
		this.req_trans_id = req_trans_id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	

}
