package com.gionee.common.msg;


import com.gionee.common.msg.MsgRspHeaderVo;
import com.gionee.common.vo.BaseMsgVo;
public class RspMsgVo extends BaseMsgVo{
	/**
	 * 消息头
	 */
	MsgRspHeaderVo header;
	
	/**
	 *消息体 
	 */
	Object body;

	public MsgRspHeaderVo getHeader() {
		return header;
	}

	public void setHeader(MsgRspHeaderVo header) {
		this.header = header;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
