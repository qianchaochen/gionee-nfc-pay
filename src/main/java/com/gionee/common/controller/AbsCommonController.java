package com.gionee.common.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.transactionMap.TransactionMapService;
import com.gionee.common.utils.CommonUtil;


/**
 * @author dingyw
 *
 *         2015年1月14日 所有请求的公共基类
 */
public abstract class AbsCommonController<T, R> implements
		ICommonController<T, R> {
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * transactionMapService业务层逻辑,根据交易码寻找对应的Controller处理
	 */
	@Autowired
	protected TransactionMapService transactionMapService;


	/**
	 * 将json对象转化为javabean，然后获取交易码
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public String getTransCode(JSONObject json) throws Exception {

		String trans_code = json.getString("trans_code");
		if (null == trans_code) {
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),
					"交易码没有设置");
		}
		return trans_code;

	}
	
	/**
	 * 将json对象转化为javabean，然后获取服务代码
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public String getServiceId(JSONObject json) throws Exception {

		String service_id = json.getString("service_id");
		if (null == service_id) {
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),
					"service_id没有设置");
		}
		return service_id;

	}

	/**
	 * 从reqeuset中获取json对象
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public JSONObject getJSONObject(HttpServletRequest request)
			throws Exception {
		try {
			String json;
			json = IOUtils.toString(request.getInputStream(),
					CharEncoding.UTF_8);
		
			String client_ip=CommonUtil.getIpAddress(request);
			
			JSONObject result=JSONObject.fromObject(json);
			
			result.put("ip", client_ip);//记录用户ip地址
			
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(),e); 
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(), "错误");
		}

	}
	/**
	 * 从reqeuset中获取json对象
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public JSONObject getUnionJSONObject(HttpServletRequest request)
			throws Exception {
		try {
			String json;
			json = IOUtils.toString(request.getInputStream(),
					CharEncoding.UTF_8);
		
			JSONObject body=JSONObject.fromObject(json);
			
			JSONObject req=new JSONObject();
			
			String client_ip=CommonUtil.getIpAddress(request);
			req.put("ip", client_ip);//记录用户ip地址
			req.put("trans_code", request.getParameter("trans_code"));
			
			req.put("xTsmCplc", request.getHeader("x-tsm-cplc"));
			req.put("xSmpsCallerid", request.getHeader("x-smps-callerid"));
			req.put("transTimeSource", request.getHeader("transTimeSource"));
			req.put("transNoSource", request.getHeader("transNoSource"));
			
			body.put("xTsmCplc", request.getHeader("x-tsm-cplc"));
			body.put("transNoSource", request.getHeader("transNoSource"));
			req.put("body", body);
			
			return req;
		} catch (Exception e) {
			log.error(e.getMessage(),e); 
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(), "错误");
		}

	}
	/**
	 * 将json对象转化为javabean对象
	 * 
	 * @param json
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public T getVoByJson(JSONObject json, Class className) throws Exception {
		JSONObject jsonObj = JSONObject.fromObject(json);
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(jsonObj, className);
		log.info("vo->"+vo);
		return vo;
	}

	/**
	 * request GET的方法提交，通过此方法将request的请求参数转为vo
	 * 
	 * @param request
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public T getVoByParam(HttpServletRequest request, Class className)
			throws Exception {
		Class<?> clazz = Class.forName(className.getName());
		@SuppressWarnings("unchecked")
		T vo = (T) clazz.newInstance();
		BeanUtils.populate(vo, request.getParameterMap());
		return vo;
	}

	/**
	 * 将request get方法的请求字符串转为json对象
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public JSONObject getJSONObjectByParameter(HttpServletRequest request)
			throws Exception {
		Enumeration enu = request.getParameterNames();
		JSONObject json = new JSONObject();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			json.put(paraName, request.getParameter(paraName));
		}
		/*
		 * 以下信息便于权限控制
		 */
		if(!StringUtils.isEmpty((String)request.getAttribute("trans_code"))){
			json.put("trans_code", request.getAttribute("trans_code"));
		}
		if(!StringUtils.isEmpty((String)request.getAttribute("req_sys"))){
			json.put("req_sys", request.getAttribute("req_sys"));
		}
		log.info("json"+json);
		return json;
	}
	public TransactionMapService getTransactionMapService() {
		return transactionMapService;
	}

	public void setTransactionMapService(
			TransactionMapService transactionMapService) {
		this.transactionMapService = transactionMapService;
	}

}
