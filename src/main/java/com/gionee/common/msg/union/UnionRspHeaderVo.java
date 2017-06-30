/**
 * 
 */
package com.gionee.common.msg.union;

import com.gionee.common.msg.MsgRspHeaderVo;

/**
 * @author zhanggq
 *
 *         2017年6月30日
 */
public class UnionRspHeaderVo extends MsgRspHeaderVo {
	private String transTimeDestination;
	private String transNoDestination;

	public String getTransTimeDestination() {
		return transTimeDestination;
	}

	public void setTransTimeDestination(String transTimeDestination) {
		this.transTimeDestination = transTimeDestination;
	}

	public String getTransNoDestination() {
		return transNoDestination;
	}

	public void setTransNoDestination(String transNoDestination) {
		this.transNoDestination = transNoDestination;
	}

}
