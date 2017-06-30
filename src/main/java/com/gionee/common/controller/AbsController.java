package com.gionee.common.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.msg.MsgRspHeaderVo;
import com.gionee.common.utils.CommonMsgUtils;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.common.vo.CommonOutMsgVo;

public abstract class AbsController extends AbsCommonController<HttpServletRequest, HttpServletResponse> {

	public void printNfcJsonResponse(HttpServletResponse resp, BaseMsgVo baseMsgVo) {
		try {
			String result = "";
			// 根据baseMsgVo获取结果,生成json,然后转化为字符串
			if (baseMsgVo instanceof CommonOutMsgVo) {// 由于引入了加解密、签名的功能，controller生成返回报文由action处理
				CommonOutMsgVo outMsg = (CommonOutMsgVo) baseMsgVo;
				result = outMsg.getRspMsg();
			} else {
				result = CommonMsgUtils.beanToJsonStr(baseMsgVo);
			}
			this.printNfcJsonResponse(resp, result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public void printNfcJsonResponse(HttpServletResponse resp, String result) {
		resp.setContentType("application/json;charset=UTF-8");
		log.info("result->" + result);
		try {
			PrintWriter out = resp.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * 对于walletRspMsgVo标准规范的报文，返回标准的json报文，钱包正常的响应报文
	 * 
	 * @param resp
	 * @param baseMsgVo
	 */
	public void printJsonResponse(HttpServletResponse resp, BaseMsgVo baseMsgVo) {
		try {
			resp.setContentType("application/json;charset=UTF-8");

			String result = CommonMsgUtils.beanToJsonStr(baseMsgVo);

			log.info("{} - response, {}" + result);
			PrintWriter out = resp.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * http响应，钱包客户端异常的响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printSysJsonResponse(HttpServletResponse resp, BizException e) {
		try {
			resp.setContentType("application/json;charset=UTF-8");
			log.info("printJsonResponse");
			MsgRspHeaderVo vo = new MsgRspHeaderVo();
			vo.setRsp_code(e.getRsp_code());
			vo.setRsp_desc(e.getRsp_desc());
			JSONObject jsonResp = JSONObject.fromObject(vo);
			JSONObject jsonbody = new JSONObject(); // 构造空的body
			jsonResp.put("body", jsonbody);
			String result = jsonResp.toString();
			log.info("response-->" + result);
			PrintWriter out = resp.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * http响应，钱包客户端异常的响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printSysJsonResponse(HttpServletResponse resp, NotRollBackBizException e) {
		try {
			resp.setContentType("application/json;charset=UTF-8");
			log.info("printJsonResponse");
			MsgRspHeaderVo vo = new MsgRspHeaderVo();
			vo.setRsp_code(e.getRsp_code());
			vo.setRsp_desc(e.getRsp_desc());
			JSONObject jsonResp = JSONObject.fromObject(vo);
			JSONObject jsonbody = new JSONObject(); // 构造空的body
			jsonResp.put("body", jsonbody);
			String result = jsonResp.toString();
			log.info("response-->" + result);
			PrintWriter out = resp.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * 钱包客户端请求异常的响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printSysJsonResponse(HttpServletResponse resp, Exception e) {
		BizException bizE = new BizException(CommonConstant.RSP_CODE.FAILED.getValue(), e.getMessage());
		this.printSysJsonResponse(resp, bizE);
	}

}
