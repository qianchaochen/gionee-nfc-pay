package com.gionee.common.service.security;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;

/**
 * @author dingyw
 *
 * 2016年8月8日
 */
public interface SecurityService {

	/**
	 * 验证签名
	 * 
	 * @param vo
	 * @return
	 */
	public void verifySign(ReqMsgVo reqMsg) throws BizException;
	
	/**验证签名,排除某些不参与签名的字段
	 * @param reqMsg
	 * @param excList，不参与签名的列表
	 * @throws BizException
	 */
	public void verifySign(ReqMsgVo reqMsg,List<String> excList)throws BizException;
	
	
	/**
	 * @param signContent
	 * @return
	 * @throws BizException
	 */
	public String getMd5(String signContent) throws BizException;
	
	/**
	 * @param signContent
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public String getMd5(String signContent,String key) throws BizException;
	
	/**根据请求报文的请求方机构，获取对应的密钥
	 * @param header
	 * @return
	 * @throws BizException
	 */
	public String getKey(MsgReqHeaderVo header) throws BizException;
	
	/**获取待签名的内容
	 * @param reqMsg
	 * @return
	 * @throws BizException
	 */
	public String getContent(ReqMsgVo reqMsg) throws BizException;
	
	/**获取待签名的内容,排除不签名的字段
	 * @param reqMsg
	 * @param excList
	 * @return
	 * @throws BizException
	 */
	public String getContent(ReqMsgVo reqMsg,List<String> excList) throws BizException;
}
