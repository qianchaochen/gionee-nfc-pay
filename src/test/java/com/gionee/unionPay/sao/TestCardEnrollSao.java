package com.gionee.unionPay.sao;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author dingyw
 *
 * 2017年6月13日
 */
public class TestCardEnrollSao extends TestImitatorBaseAction{
	
	public void execute() throws UnsupportedEncodingException {
		//是否采用本地环境还是测试环境
		this.setEnv("test");

		this.setxTsmCplc("x_tsm_cplc_000001");
		
		this.setX_smps_callerid("x_smps_callerid_000001");
		
		this.setUri("/TSM/platform/cardenroll");
		
        
        JSONObject jsonBody = new JSONObject();
		
        JSONObject cipheredCardInfo=new JSONObject();
        
        cipheredCardInfo.put("cardInfo", "6222000100020003|15816883431");
        cipheredCardInfo.put("pin", "123456");
        cipheredCardInfo.put("cvn2", "");
		jsonBody.put("cipheredCardInfo", cipheredCardInfo);
		jsonBody.put("tncStatus", "ACCEPTED");
		//00-	银行自有渠道  01-	全手机厂商渠道
		jsonBody.put("applyChannel", "01");
		
		JSONObject riskInfo=new JSONObject();
		riskInfo.put("deviceType", "1"); //1:手机，2:平板，3:手表
		riskInfo.put("deviceName", "sunsnow的手机");
		//用户移动设备卡申请渠道类型。00:银行自有渠道，01: 手机厂商渠道，02: 银联渠道，03: 运营商渠道
		riskInfo.put("applyChannel", "01");
		riskInfo.put("extensiveDeviceLocation", "+37.12/-121.23");
		//表示卡号录入方式。manual：用户手输入卡号，camera：表示摄像头捕捉得到卡号，unknow：未知的获取卡号方式
		riskInfo.put("captureMethod", "manual"); 
		riskInfo.put("deviceNumber", "3431"); 
		riskInfo.put("sourceIP", "127.0.0.1"); 
		riskInfo.put("deviceSIMNumber", "1"); //智能设备中的SIM卡数量
		
		
		jsonBody.put("riskInfo", riskInfo);

        String json=jsonBody.toJSONString(JSONStyle.NO_COMPRESS);
        
        HttpPost httpPost = this.getHttpHost(json);    
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        try (CloseableHttpResponse response = httpClient.execute(httpPost)){
        	System.out.println("transTimeDestination->"+response.getHeaders("transTimeDestination")[0]);
        	System.out.println("transNoDestination->"+response.getHeaders("transNoDestination")[0]);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
            	String result=EntityUtils.toString(entity, StandardCharsets.UTF_8);
                System.out.println(result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

	}
	
	public static void main(String[] args) {
		TestCardEnrollSao t=new TestCardEnrollSao();
		try {
			t.execute();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
