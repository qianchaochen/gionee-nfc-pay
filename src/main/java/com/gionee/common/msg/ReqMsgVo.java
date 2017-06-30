package com.gionee.common.msg;

import com.gionee.common.vo.BaseMsgVo;
public class ReqMsgVo extends BaseMsgVo{
	/**
	 * 消息头
	 */
	MsgReqHeaderVo header;
	
	/**
	 *消息体 
	 */
	Object body;

	public MsgReqHeaderVo getHeader() {
		return header;
	}

	public void setHeader(MsgReqHeaderVo header) {
		this.header = header;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
	

}
