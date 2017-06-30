package com.gionee.common.msg;

import com.gionee.common.vo.BaseMsgVo;


public class MsgRspHeaderVo extends BaseMsgVo{
	private String 	rsp_code	;//	应答/错误代码
	private String 	rsp_desc	;//	应答/错误描述
	private String 	access_token	;//	支付信令
	private String 	rcv_sys	;//	接收方系统
	private String 	rcv_date	;//	接收方交易日期
	private String 	rcv_trans_id	;//	接收方交易流水号
	private String 	rcv_time	;//	接收方时间戳

	private String  body;//报文体

	public String getRsp_code() {
		return rsp_code;
	}

	public void setRsp_code(String rsp_code) {
		this.rsp_code = rsp_code;
	}

	public String getRsp_desc() {
		return rsp_desc;
	}

	public void setRsp_desc(String rsp_desc) {
		this.rsp_desc = rsp_desc;
	}

	public String getRcv_sys() {
		return rcv_sys;
	}

	public void setRcv_sys(String rcv_sys) {
		this.rcv_sys = rcv_sys;
	}

	public String getRcv_date() {
		return rcv_date;
	}

	public void setRcv_date(String rcv_date) {
		this.rcv_date = rcv_date;
	}

	public String getRcv_trans_id() {
		return rcv_trans_id;
	}

	public void setRcv_trans_id(String rcv_trans_id) {
		this.rcv_trans_id = rcv_trans_id;
	}

	public String getRcv_time() {
		return rcv_time;
	}

	public void setRcv_time(String rcv_time) {
		this.rcv_time = rcv_time;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
