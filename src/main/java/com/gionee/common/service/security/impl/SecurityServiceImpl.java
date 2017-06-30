package com.gionee.common.service.security.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.service.security.SecurityService;
import com.gionee.common.utils.Md5Util;
import com.gionee.common.utils.SecurityUtils;
import com.gionee.common.vo.BaseVo;

/**
 * 安全验证服务
 * @author dingyw
 *
 * 2016年8月8日
 */
@Service
public class SecurityServiceImpl implements SecurityService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 请求的md5密钥
	 */
	private String md5_secret_key;
	

	@Override
	public void verifySign(ReqMsgVo reqMsg) throws BizException {
		
		MsgReqHeaderVo header=reqMsg.getHeader();
		//获取请求的报文头带来的签名
		String sign=header.getSign();
		if(StringUtils.isEmpty(sign)){
			throw new BizException("签名字段不能为空");
		}
		
		String content=this.getContent(reqMsg); //获取待签名的字符串
		String result=null;
		try {
			result = Md5Util.getAmigoMd5(content);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//进行签名比较
		if(!sign.equals(result)){
			throw new BizException("验签失败");
		}
	}
	
	/**
	 * @param reqMsg
	 * @param excList
	 * @throws BizException
	 */
	@Override
	public void verifySign(ReqMsgVo reqMsg,List<String> excList)throws BizException{
		MsgReqHeaderVo header=reqMsg.getHeader();
		//获取请求的报文头带来的签名
		String sign=header.getSign();
		if(StringUtils.isEmpty(sign)){
			throw new BizException("签名字段不能为空");
		}
		
		String content=this.getContent(reqMsg,excList); //获取待签名的字符串
		String result=null;
		try {
			result = Md5Util.getAmigoMd5(content);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//进行签名比较
		if(!sign.equals(result)){
			throw new BizException("验签失败");
		}
	}
	
	/**参与签名的内容
	 * @param reqMsg
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getContent(ReqMsgVo reqMsg) throws BizException{
		String content=SecurityUtils.getAscStr((BaseVo)reqMsg.getBody());
		
		String key=this.getKey(reqMsg.getHeader()); //根据不同的请求方，获取key
		
		content=content+"&"+key; //拼接key
		
		return content;
	}

	/**参与签名的内容，排除不参与签名的字段
	 * @param reqMsg
	 * @param list 不参与签名的字段
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getContent(ReqMsgVo reqMsg,List<String> excList) throws BizException{
		String content=SecurityUtils.getAscStr((BaseVo)reqMsg.getBody(),excList);
		
		String key=this.getKey(reqMsg.getHeader()); //根据不同的请求方，获取key
		
		content=content+"&"+key; //拼接key
		
		return content;
	}
	
	@Override
	public String getKey(MsgReqHeaderVo header) throws BizException{
		String key=null;
		if(header.getReq_sys().equals(CommonConstant.COMMON_SYS_CODE.SELF_SYS_CODE.getValue())){
			key=md5_secret_key;
		}else{
			throw new BizException("请求机构代码错误");
		}
		return key;
	}
    
	@Override
	public String getMd5(String signContent) throws BizException {
		String sign;
		try {
			sign = Md5Util.getAmigoMd5(signContent);
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("签名出错");
		}
	}

	@Override
	public String getMd5(String signContent,String key) throws BizException {
		String sign;
		String content=signContent+"&"+key; //用传进来的key
		try {
			sign = Md5Util.getAmigoMd5(content);
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("签名出错");
		}
	}
	
	public String getMd5_secret_key() {
		return md5_secret_key;
	}

	@Value("#{nfcPay_config['md5_secret_key']}")
	public void setMd5_secret_key(String md5_secret_key) {
		this.md5_secret_key = md5_secret_key;
	}
	
}
