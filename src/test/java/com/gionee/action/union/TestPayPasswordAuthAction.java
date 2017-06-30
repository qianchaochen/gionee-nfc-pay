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
public class TestPayPasswordAuthAction extends TestBaseAction{
	public void excuete(){
		//指定执行环境
		this.setEnv("localhost");
		//设置请求url
		String url=this.getUrl();
		//指定交易码
		this.setTrans_code("310008");
	
		//创建报文头
		JSONObject jsonReq = this.getHeader();
		
		//创建报文体
		JSONObject jsonBody = new JSONObject();

		jsonBody.put("user_token", "123");
		jsonBody.put("uid", "E096D034365146B0A73DFAC5AB94A333");
		jsonBody.put("phone_no", "13760464403");
		jsonBody.put("passwd", "123456");
		jsonBody.put("is_fingerprint", "0");
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
		TestPayPasswordAuthAction t=new TestPayPasswordAuthAction();
		t.excuete();
	}
}
