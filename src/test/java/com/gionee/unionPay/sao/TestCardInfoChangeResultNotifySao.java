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
 * 2017年6月26日
 */
public class TestCardInfoChangeResultNotifySao extends TestImitatorBaseAction{

	public void execute() throws UnsupportedEncodingException {
		//是否采用本地环境还是测试环境
		this.setEnv("lo");

		this.setxTsmCplc("x_tsm_cplc_000001");
		
		this.setX_smps_callerid("x_smps_callerid_000001");
		
		this.setUri("/TSM/platform/operationresultnotify");
		  
        JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("event", "METAUPDATE"); //事件名称
		jsonBody.put("virtualCardRefId", "virtualCardRefId_000001"); //设备卡PAN别名
		
		//成功：00 失败：01
		jsonBody.put("result", "00"); 


		jsonBody.put("taskId", "taskId_000001"); //任务流水号

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
		TestCardInfoChangeResultNotifySao t=new TestCardInfoChangeResultNotifySao();
		try {
			t.execute();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
