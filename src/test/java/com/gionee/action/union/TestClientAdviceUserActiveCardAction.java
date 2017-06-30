/**
 * 
 */
package com.gionee.action.union;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.AmigoHttpUtils;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

/**
 * @author qiancc
 *
 * 2017年6月27日
 */
public class TestClientAdviceUserActiveCardAction extends TestBaseAction{
	public void excuete(){
		//指定执行环境
		this.setEnv("localhost");
		//设置请求url
		String url=this.getUrl();
		//指定交易码
		this.setTrans_code("220003");
	
		//创建报文头
		JSONObject jsonReq = this.getHeader();
		
		//创建报文体
		JSONObject jsonBody = new JSONObject();

		jsonBody.put("xTsmCplc","abcdef");
		jsonBody.put("user_id", "E096D034365146B0A73DFAC5AB94A333");
		jsonBody.put("phone_no","13412345678");
		jsonBody.put("card_no","card_no_0002");
		jsonBody.put("aid","aid_0002");
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
		TestClientAdviceUserActiveCardAction t=new TestClientAdviceUserActiveCardAction();
		t.excuete();
	}
}
