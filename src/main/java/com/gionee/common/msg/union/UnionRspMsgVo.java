/**
 * 
 */
package com.gionee.common.msg.union;

import com.gionee.common.vo.BaseMsgVo;

/**
 * @author zhanggq
 *
 *         2017年6月30日
 */
public class UnionRspMsgVo extends BaseMsgVo {
	/**
	 * 消息头
	 */
	UnionRspHeaderVo header;

	/**
	 * 消息体
	 */
	Object body;

	public UnionRspHeaderVo getHeader() {
		return header;
	}

	public void setHeader(UnionRspHeaderVo header) {
		this.header = header;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
