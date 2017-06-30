package com.gionee.common.multidataSource;

/**
 * @author dingyw
 *
 * 2015年2月6日
 */
@SuppressWarnings("unchecked")
public class DataSourceContextHolder {   
 
   /**  
    * DataSource上下文，每个线程对应相应的数据源key  
    */  
    @SuppressWarnings("rawtypes")
	public static final ThreadLocal contextHolder = new ThreadLocal();   
       
    public static void setDataSourceType(String dataSourceType)   
    {   
        contextHolder.set(dataSourceType);   
    }   
       
    public static String getDataSourceType()   
    {   
        return (String)contextHolder.get();   
    }   
       
    public static void clearDataSourceType()   
    {   
        contextHolder.remove();   
    }   
}  