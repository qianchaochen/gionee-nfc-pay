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
public class TestDeviceStatusChangeAction extends TestBaseAction{
	public void excuete(){
		//指定执行环境
		this.setEnv("localhost");
		//设置请求url
		String url=this.getUrl();
		//指定交易码
		this.setTrans_code("310006");
	
		//创建报文头
		JSONObject jsonReq = this.getHeader();
		
		//创建报文体
		JSONObject jsonBody = new JSONObject();

		jsonBody.put("event", "LOCK_DEVICE");
		jsonBody.put("secureElement", "x_tsm_cplc_000001");
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
		TestDeviceStatusChangeAction t=new TestDeviceStatusChangeAction();
		t.excuete();
	}
}
