package com.gionee.nfcPay.service.cache;

import java.util.HashMap;
import java.util.Map;

import com.gionee.nfcPay.vo.models.NfcCoreOrgSafeInfoTab;


/**
 * @author dingyw
 *
 * 2017年6月27日
 */
public class OrgSafeInfoCache {
	/**
	 * 存放机构安全信息的cacheMap
	 */
	private static Map<String,NfcCoreOrgSafeInfoTab> cacheMap= new HashMap<String,NfcCoreOrgSafeInfoTab>();
	
	/**
	 * 存放机构安全信息的cacheMap
	 */
	private static Map<String,Long> cacheTimeMap= new HashMap<String,Long>();
	
	private static int cache_time_out=1000*60; //超时时间设置为1分钟
	
	
	public static void put(String org_id,String version, NfcCoreOrgSafeInfoTab nfcCoreOrgSafeInfoTab) { 
		//拼接起来作为key
		String key=org_id+version;
		//放进缓存
		cacheMap.put(key, nfcCoreOrgSafeInfoTab); 
		//时间放进缓存
		cacheTimeMap.put(key, System.currentTimeMillis());
	}
	public static NfcCoreOrgSafeInfoTab get(String org_id,String version) { 
		//拼接起来作为key
		String key=org_id+version;

		//获取缓存
		NfcCoreOrgSafeInfoTab epayCoreOrgSafeInfoTab= cacheMap.get(key); 
		
		//判断是否超过缓存时间
		if(epayCoreOrgSafeInfoTab!=null){	
			if(System.currentTimeMillis()-cacheTimeMap.get(key)>=cache_time_out)
				return null;
		}
		return epayCoreOrgSafeInfoTab;
	}
}
