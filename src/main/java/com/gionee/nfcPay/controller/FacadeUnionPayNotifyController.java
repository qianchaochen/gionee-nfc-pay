package com.gionee.nfcPay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gionee.common.action.IBaseAction;
import com.gionee.common.constant.CommonConstant;
import com.gionee.common.controller.AbsController;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 *         2017年06月26日
 *         银联所有通知都发送到FacadeUnionPayNotifyController，然后由FacadeNfcPayController根据
 *         交易代码路由到不同的Action进行处理
 */
@Controller
public class FacadeUnionPayNotifyController extends AbsController {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Override
	@RequestMapping(value = "/unionPayNotifyService")
	//统一入口和统一出口，Controller与Action之间只允许传递Json和vo对象，不能将controller的request或resp对象传到action层
	public void doService(HttpServletRequest request, HttpServletResponse response) {
		
		log.info("enter FacadeUnionPayNotifyController~~~~");

		try {
			JSONObject jsonReq=this.getUnionJSONObject(request);//从request获取json
			
			//获取交易码
			String transCode = this.getTransCode(jsonReq);

			// 根据容器的配置信息,根据交易码找到对应的处理action
			IBaseAction<BaseMsgVo> action = transactionMapService.getActionByMap(transCode);
			
			if(null==action){
				throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),"交易码错误");
			}
			BaseMsgVo msgVo = (BaseMsgVo) action.getMsg(jsonReq);// 每个action对应不同的msgVo，由具体的action来指定具体的Vo，并把
			
			log.info("msgVo->"+msgVo);// json对象转化为vo
			BaseMsgVo resultvo=action.execute(msgVo);// 根据容器的配置信息，调用不同的action进行服务
			
			 //将正常结果通过resp返回json对象 
			log.info("resultvo->"+resultvo);
			
			this.printJsonResponse(response, resultvo);
			
		}catch(NotRollBackBizException e){
			log.error(e.getMessage(),e); 
			this.printSysJsonResponse(response, e);
		}catch(BizException e){
			log.error(e.getMessage(),e); 
			this.printSysJsonResponse(response, e);
		}catch (Exception e) {
			log.error(e.getMessage(),e); 
			this.printSysJsonResponse(response, e);	

		}
	}

}
