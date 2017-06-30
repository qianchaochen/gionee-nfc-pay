package com.gionee.common.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.union.UnionMsgReqHeaderVo;
import com.gionee.common.msg.union.UnionReqMsgVo;
import com.gionee.common.utils.JsonUtils;
import com.gionee.common.utils.MsgUtils;
import com.gionee.common.utils.TransIdSerial;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.common.vo.CommonOutMsgVo;
import com.gionee.epay.client.EpaySDKRcv;
import com.gionee.nfcPay.facade.CommomServiceCheckFacade;
import com.gionee.nfcPay.service.security.NfcSecurityFacade;
import com.gionee.nfcPay.service.union.NfcUnionCoreTxnLogService;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;

/**
 * @author dingyw
 *
 *         2017年6月27日
 */
public abstract class AbsBaseAction<T> implements IBaseAction<T> {
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 公共校验模块
	 */
	@Autowired
	protected CommomServiceCheckFacade commomServiceCheckFacade;

	/**
	 * 事务模块
	 */
	@Autowired
	protected NfcUnionCoreTxnLogService nfcUnionCoreTxnLogService;

	/**
	 * 安全控制模块
	 */
	@Autowired
	protected NfcSecurityFacade nfcSecurityFacade;

	public BaseMsgVo doAction(JSONObject json) throws Exception { // 由子类覆盖
		return null;
	}

	public T getMsg(JSONObject json) throws Exception {// 由子类覆盖
		return null;
	}

	/**
	 * 子类覆盖该类，实现返回报文是否需要签名
	 * 
	 * @return
	 */
	public boolean is_need_sign() {
		return false;
	}

	/**
	 * 子类覆盖该类，实现返回报文是否需要加密
	 * 
	 * @return
	 */
	public boolean is_need_encry() {
		return false;
	}

	public T getMsg(JSONObject json, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className);
		return vo;
	}
	public T getFastJsonMsg(String json, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JsonUtils.readJson2Object(json, className);
		return vo;
	}
	// 处理由sdk发出的请求
	@Override
	public BaseMsgVo execute_sdk(JSONObject req) throws Exception {
		// 如果报文是加密的，则对报文进行解密，返回EpaySDKRcvReq对象，包含解密后的明文和密钥，密钥用于返回报文的加密
		EpaySDKRcv epaySDKRcv = this.getEpaySDKRcv(req);

		req = this.getJson(epaySDKRcv, req);

		// 调用主流程,由子类覆盖
		BaseMsgVo baseMsgVo = doAction(req);

		if (epaySDKRcv != null) {
			// 设置返回报文是否签名
			epaySDKRcv.setSign_open(this.is_need_sign());

			// 设置返回报文是否加密
			epaySDKRcv.setEncrypt_open(this.is_need_encry());

			// 将javabean result转为json String,
			String result = MsgUtils.beanToJsonStr(baseMsgVo);

			// 根据开关情况，调用SDK对返回报文进行签名、加密
			String rspMsg = epaySDKRcv.getRspMsg(result);

			// 生成返回的vo
			CommonOutMsgVo outMsg = new CommonOutMsgVo();
			outMsg.setRspMsg(rspMsg);

			return outMsg; // 返回加密、签名后的报文
		}
		return baseMsgVo; // 返回原来的
	}

	/**
	 * 取公钥对进行RSA解密key,然后用解密后的aes_key进行aes解密，然后获得原文,最后返回json
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	protected EpaySDKRcv getEpaySDKRcv(JSONObject json) throws Exception {
		// 判断是否加密过
		String key = null;
		try {
			key = json.getString("key");
		} catch (Exception e) {

		}
		// 如果已经加密
		if (!StringUtils.isEmpty(key)) {
			log.info("getDecryptJson:" + json);
			// 取公钥对进行RSA解密key,然后用解密后的aes_key进行aes解密，然后获得原文
			EpaySDKRcv epaySDKRcvReq = nfcSecurityFacade.decryptReqMessage(json);

			return epaySDKRcvReq;
		}
		// 如果没有加密，则返回空
		return null;

	}

	public ReqMsgVo getMsgVo(JSONObject json, Map<String, Class> classMap, Class className) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 先获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, classMap, className));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}
		JSONObject temp = JSONObject.fromObject(json);
		temp.remove("body");// 需要去掉，不然会报错
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(temp, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		return vo;
	}

	public ReqMsgVo getMsgVo(JSONObject json, String itemName, Class className, Class itemClassName)
			throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 先获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, itemName, className, itemClassName));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}
		JSONObject temp = JSONObject.fromObject(json);
		temp.remove("body");// 需要去掉，不然会报错
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(temp, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		return vo;
	}

	public T getMsg(JSONObject json, Map<String, Class> classMap, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className, classMap);
		return vo;
	}

	public T getMsg(JSONObject json, String itemName, Class className, Class itemClassName) throws Exception {
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put(itemName, itemClassName);
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className, classMap);
		return vo;
	}

	/**
	 * 根据json，返回MsgVo，其中报文头的类固定，报文体的类根据className不同而不同
	 * 
	 * @param json
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public ReqMsgVo getMsgVo(JSONObject json, Class className) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(json, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		// 获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, className));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}

		return vo;
	}

	/**
	 * 根据json，返回MsgVo，其中报文头的类固定，报文体的类根据className不同而不同
	 * 
	 * @param json
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public UnionReqMsgVo getFastJsonMsgVo(JSONObject json, Class className) throws Exception {
		UnionReqMsgVo vo = new UnionReqMsgVo();
		// 获取报文头
		UnionMsgReqHeaderVo header = (UnionMsgReqHeaderVo) this.getFastJsonMsg(json.toString(), UnionMsgReqHeaderVo.class);

		vo.setHeader(header);

		// 获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			vo.setBody(this.getFastJsonMsg(json.get("body").toString(), className));
		} else {
			T body = (T) className.newInstance();
			vo.setBody(body);
		}

		return vo;
	}

	/**
	 * 根据json，返回MsgVo，无报文体
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public ReqMsgVo getMsgVo(JSONObject json) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		/*
		 * 获取报文头
		 */
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(json, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);
		return vo;
	}

	public T getEncMsgVo(JSONObject json, Class className) throws Exception {
		return this.getMsg(json, className);
	}

	public T getVoByParam(HttpServletRequest request, Class className) throws Exception {

		Class<?> clazz = Class.forName(className.getName());
		@SuppressWarnings("unchecked")
		T vo = (T) clazz.newInstance();
		BeanUtils.populate(vo, request.getParameterMap());
		return vo;

	}

	public void onSuccess(NfcUnionCoreTxnLog txn) throws BizException {
		nfcUnionCoreTxnLogService.updateTxnSucc(txn);
	}

	public void onFail(NfcUnionCoreTxnLog txn, Exception e) throws BizException {
		if (null != e && !StringUtils.isEmpty(e.getMessage())) {
			if (e.getMessage().length() >= 200) {
				txn.setFail_reason(e.getMessage().substring(0, 200)); //
			} else {
				txn.setFail_reason(e.getMessage());
			}
		}
		nfcUnionCoreTxnLogService.updateTxnFail(txn);
	}

	protected JSONObject getJson(EpaySDKRcv epaySDKRcv, JSONObject json) {

		if (epaySDKRcv != null) {
			// 解密后的报文重新组装成json
			JSONObject result = JSONObject.fromObject(epaySDKRcv.getMessage());
			result.put("ip", json.getString("ip"));

			json = result; // 如果加密，则返回解密后的
		}
		return json;// 如果没有加密，则返回原来的json
	}

}
