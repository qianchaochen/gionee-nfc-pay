package com.gionee.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.msg.MsgRspHeaderVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2015年11月27日
 */
public class CommonMsgUtils {
	
	public static String beanToJsonStr(BaseMsgVo baseMsgVo){
		RspMsgVo vo = (RspMsgVo) baseMsgVo;
		JSONObject jsonRsp=null;
		if(vo.getHeader()==null){
			jsonRsp = JSONObject.fromObject(getHeader());//如果业务层不特别指定报文头，则采用通用报文头返回
		}else{
			jsonRsp = JSONObject.fromObject(vo.getHeader());	//如果业务层指定了报文头，则采用业务层返回的报文头(特殊情况下使用)
		}
		if(!StringUtils.isEmpty(vo.getBody())){
			JSONObject jsonbody = JSONObject.fromObject(vo.getBody());
			jsonRsp.put("body", jsonbody);
		}else{
			JSONObject jsonbody=new JSONObject();
			jsonRsp.put("body", jsonbody);
		}
		
		String result = jsonRsp.toString();
		return result;
	}
	/**设置返回报文头
	 * @return
	 */
	public static MsgRspHeaderVo getHeader(){
		MsgRspHeaderVo header=new MsgRspHeaderVo();
		header.setRsp_code(CommonConstant.RSP_CODE.SUCCESS.getValue());
		header.setRsp_desc(CommonConstant.RSP_CODE.SUCCESS.getDesc());
		header.setAccess_token(""); //一般返回报文不需要设置access_token
		
		header.setRcv_sys(CommonConstant.COMMON_SYS_CODE.SELF_SYS_CODE.getValue());
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		header.setRcv_date(sdf.format(date));
		sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		header.setRcv_time(sdf.format(date));
		header.setRcv_trans_id(SeqIdSerial.genSeqId(CommonConstant.SEQ_TYPE.RETURN.getValue()));//生成返回的序列号
		return header;
	}
}
