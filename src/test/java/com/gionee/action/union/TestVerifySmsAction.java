/**
 * 
 */
package com.gionee.action.union;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.AmigoHttpUtils;

/**
 * @author zhanggq
 *
 * 2017年6月22日
 */
public class TestVerifySmsAction extends TestBaseAction{
	public void excuete(){
		//指定执行环境
		this.setEnv("localhost");
		//设置请求url
		String url=this.getUrl();
		//指定交易码
		this.setTrans_code("310004");
	
		//创建报文头
		JSONObject jsonReq = this.getHeader();
		
		//创建报文体
		JSONObject jsonBody = new JSONObject();

		jsonBody.put("xTsmCplc", "1234567890");
		jsonBody.put("virtualCardRefId", "virtualCardRefId_000001");
		jsonBody.put("otpValue", "123456");
		//报文体加入到报文头 
		jsonReq.put("body", jsonBody);
		
		
		String req_plain=jsonReq.toJSONString(JSONStyle.NO_COMPRESS);
		System.out.println(req_plain);
		try {
			this.setEncrypt_open(true);
			this.setSign_open(true);
			String req = this.getSDKRequest(req_plain);
			String response=AmigoHttpUtils.post(url, req);
			System.out.println("response:"+response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TestVerifySmsAction t=new TestVerifySmsAction();
		t.excuete();
	}
}
