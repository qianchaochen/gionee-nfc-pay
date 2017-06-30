package com.gionee.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;

import com.gionee.common.exception.BizException;
import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2016年8月8日
 */
public class SecurityUtils {
    
	/**获取签名的字符串
	 * 密钥另外配置
	 * @param vo
	 * @param secret_key
	 * @return
	 * @throws BizException 
	 */
	public static String getAscStr(BaseVo vo) throws BizException{
		//获取bean中各字段放入map中
		Map<String,String> map=CommonBeanUtils.bean2Map(vo);
		
		//将map中的字段排序然后进行拼接
		return SecurityUtils.mapToAscString(map);
	}
	/**excList为不参与签名的字段
	 * @param vo
	 * @param excList
	 * @return
	 * @throws BizException
	 */
	public static String getAscStr(BaseVo vo,List<String> excList) throws BizException{
		//获取bean中各字段放入map中
		Map<String,String> map=CommonBeanUtils.bean2Map(vo);
		
		if(null!=excList && excList.size()>0){
			
			for(int i=0;i<excList.size();i++){
				map.remove(excList.get(i));
			}
		}
		
		//将map中的字段排序然后进行拼接
		return SecurityUtils.mapToAscString(map);
	}
	/**获取签名的字符串
	 * @param vo
	 * @param secret_key
	 * @return
	 * @throws JSONException 
	 */
	public static String getAscStr(String json) throws BizException{
		
		try {
			//获取排序后的字段列表
			Map<String,String> map=CommonBeanUtils.jsonToMap(json);
			
			//将map字段进行排序，然后拼接
			return SecurityUtils.mapToAscString(map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BizException("获取签名错误");
		} 
	}
	
	/**获取签名的字符串
	 * @param json
	 * @param excFieldNameList 不参与签名的字段
	 * @return
	 * @throws BizException
	 */
	public static String getAscStr(String json,List<String> excList) throws BizException{
		
		try {
			//获取排序后的字段列表
			Map<String,String> map=CommonBeanUtils.jsonToMap(json);
			
			if(null!=excList && excList.size()>0){
				
				for(int i=0;i<excList.size();i++){
					map.remove(excList.get(i));
				}
			}
			
			//将map字段进行排序，然后拼接
			return SecurityUtils.mapToAscString(map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BizException("获取签名错误");
		} 
	}
	//将map的内容排序，然后拼接字符串
	private static String mapToAscString(Map<String,String> map){
		
		//获取排序后的列表
		List<Entry<String,String>>  list=BaseSafeUtils.getAscList(map);
		
		if(list==null||list.size()==0){
			return null;
		}
		//把列表拼接成字符串
		String result=BaseSafeUtils.listToStr(list);
		
		return result;
	}
}
