package com.gionee.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author dingyw
 *
 * 2016年8月8日
 */
public class CommonBeanUtils {
    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
    public static Map<String, String> bean2Map(Object obj) {  
  
        if(obj == null){  
            return null;  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    String value = (String)getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    } 

    public static Map<String, String> jsonToMap(String jsonStr) throws JSONException{
  
    	 JSONObject json = new JSONObject(jsonStr);
    	 Map <String, String>result = new HashMap<String, String>();
         Iterator<?> iter = json.keys();
         String key = null;
         String value = null;
         
         while (iter.hasNext()) {

             key = (String) iter.next();
             value = json.getString(key);
             result.put(key, value);

         }
         return result;
    }
}
