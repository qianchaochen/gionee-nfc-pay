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
public class TestCardStatusChangeSao extends TestImitatorBaseAction{
	
	public void execute() throws UnsupportedEncodingException {
		//是否采用本地环境还是测试环境
		this.setEnv("test");

		this.setxTsmCplc("x_tsm_cplc_000001");
		
		this.setX_smps_callerid("x_smps_callerid_000001");
		
		this.setUri("/TSM/platform/devicestatuschange");
		  
        JSONObject jsonBody = new JSONObject();
		/*
		 *  设备锁定：LOCK_DEVICE
			设备擦除：WIPE_DEVICE
			设备重置：RESET_DEVICE
		 */
		jsonBody.put("event", "LOCK_DEVICE");
		jsonBody.put("secureElement", "x_tsm_cplc_000001");

        String json=jsonBody.toJSONString(JSONStyle.NO_COMPRESS);
        
        HttpPost httpPost = this.getHttpHost(json);    
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        try (CloseableHttpResponse response = httpClient.execute(httpPost)){
        	System.out.println("状态码： "+response.getStatusLine().getStatusCode());
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
		TestCardStatusChangeSao t=new TestCardStatusChangeSao();
		try {
			t.execute();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
