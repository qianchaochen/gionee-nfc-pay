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
public class TestDeleteCardSao extends TestImitatorBaseAction{
	
	public void execute() throws UnsupportedEncodingException {
		//是否采用本地环境还是测试环境
		this.setEnv("test");

		this.setxTsmCplc("x_tsm_cplc_000001");
		
		this.setX_smps_callerid("x_smps_callerid_000001");
		
		String virtualCardRefId="virtualCardRefId_000001";
		this.setUri("/TSM/platform/delete/"+virtualCardRefId);
		
        JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("status", "DELETED");
		jsonBody.put("reason", "USER_DELETION");

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
		TestDeleteCardSao t=new TestDeleteCardSao();
		try {
			t.execute();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
