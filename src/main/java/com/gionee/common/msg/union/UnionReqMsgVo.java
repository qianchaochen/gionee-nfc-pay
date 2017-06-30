package com.gionee.common.msg.union;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2017年6月27日
 */
public class UnionReqMsgVo extends BaseMsgVo{

	/**
	 * 消息头
	 */
	UnionMsgReqHeaderVo header;
	
	/**
	 *消息体 
	 */
	Object body;

	public UnionMsgReqHeaderVo getHeader() {
		return header;
	}

	public void setHeader(UnionMsgReqHeaderVo header) {
		this.header = header;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
	
}
