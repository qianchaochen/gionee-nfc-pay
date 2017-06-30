package com.gionee.unionPay.sao;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.minidev.json.JSONObject;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import com.gionee.common.service.security.impl.SecurityServiceImpl;
import com.gionee.common.utils.SecurityUtils;

public class TestImitatorBaseAction {
	
	//根据is_local_env判断是本地环境还是测试环境
	String url_local="http://localhost:8080/gionee-union-pay-imitator";   //本地环境
	String url_test="http://121.41.108.162:8099/gionee-union-pay-imitator";  //测试环境
	String url_product="http://settle-core.gionee.com/gionee-nfc-pay/nfcService.do";  //生产环境
	
	protected String trans_code;
	
	protected String req_sys="0052";
	//local:本地环境,test:测试环境，product：生产环境
	protected String  env="local";
	
	/**
	 * 安全载体CPCL
	 */
	protected String xTsmCplc;
	
	/**
	 * 交易请求方标识
	 */
	protected String x_smps_callerid;
	
	/**
	 * 请求的uri
	 */
	protected String uri;
	
	protected String secret_key_local="12345678";
	protected String secret_key_test="12345678!";
	protected String secret_key_product="12345678";
	
	public JSONObject getHeader(){
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmss");
		JSONObject jsonReq = new JSONObject(); 
		jsonReq.put("trans_code",trans_code);
		jsonReq.put("req_sys", req_sys);
		jsonReq.put("req_date", sdf.format(date));
		jsonReq.put("req_time", sdf2.format(date));
		jsonReq.put("version", "1.0.0");
		return jsonReq;
	}
	public String getUrl(){
		if(this.env.equals("test")){
			return url_test;
		}else if(this.env.equals("product")){
			return url_product;
		}
		return url_local;
	}
	public String getSecretKey(){
		
		String key=null;
		if(this.req_sys.equals("0001")){
			if(this.env.equals("test")){
				key= secret_key_test;
			}else if(this.env.equals("product")){
				key= secret_key_product;
			}else{
				key= secret_key_local;
			}
		}
		return key;
	}
	public void setSign(JSONObject jsonReq,JSONObject jsonBody){
		try {
			String signContent=SecurityUtils.getAscStr(jsonBody.toJSONString());
			
			SecurityServiceImpl security=new SecurityServiceImpl();
			String sign=security.getMd5(signContent,this.getSecretKey());
			jsonReq.put("sign", sign);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public HttpPost getHttpHost(String json){
        HttpPost httpPost = new HttpPost(this.getUrl()+uri);
        
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
        httpPost.addHeader("x-tsm-cplc", this.getxTsmCplc()); //安全载体CPLC
        httpPost.addHeader("x-smps-callerid", this.getX_smps_callerid()); //交易请求方标识
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        httpPost.addHeader("transTimeSource", sdf.format(date)); //发起方交易时间
        httpPost.addHeader("transNoSource", Long.toString(System.currentTimeMillis()));
        
        StringEntity se;
		try {
			se = new StringEntity(json);
			se.setContentEncoding("utf-8");
			se.setContentType("application/json");
			httpPost.setEntity(se);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return httpPost;
	}
	
	public HttpGet getHttpGet(){
		HttpGet httpGet = new HttpGet(this.getUrl()+uri);
        
		httpGet.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
		httpGet.addHeader("x-tsm-cplc", this.getxTsmCplc()); //安全载体CPLC
		httpGet.addHeader("x-smps-callerid", this.getX_smps_callerid()); //交易请求方标识
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        httpGet.addHeader("transTimeSource", sdf.format(date)); //发起方交易时间
        httpGet.addHeader("transNoSource", Long.toString(System.currentTimeMillis()));
        

        return httpGet;
	}
	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}
	public String getReq_sys() {
		return req_sys;
	}
	public void setReq_sys(String req_sys) {
		this.req_sys = req_sys;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}

	public String getX_smps_callerid() {
		return x_smps_callerid;
	}
	public void setX_smps_callerid(String x_smps_callerid) {
		this.x_smps_callerid = x_smps_callerid;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getxTsmCplc() {
		return xTsmCplc;
	}
	public void setxTsmCplc(String xTsmCplc) {
		this.xTsmCplc = xTsmCplc;
	}
	
}
