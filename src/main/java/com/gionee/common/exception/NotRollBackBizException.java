package com.gionee.common.exception;

import com.gionee.common.constant.CommonConstant;

/**
 * 定义一个不需要回滚的特殊的异常
 * @author dingyw
 *
 * 2015年8月14日
 */
public class NotRollBackBizException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4881005031885404771L;
	private String rsp_code;
	private String rsp_desc;
	
	public NotRollBackBizException(String rsp_code,String rsp_desc){
		super(rsp_desc);
		this.rsp_code=rsp_code;
		this.rsp_desc=rsp_desc;
	}
	
	public NotRollBackBizException(String rsp_desc){
		super(rsp_desc);
		this.rsp_code=CommonConstant.RSP_CODE.FAILED.getValue();
		this.rsp_desc=rsp_desc;
	}
	
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
	public String toString(){
		return rsp_code+":"+rsp_desc;
	}

}