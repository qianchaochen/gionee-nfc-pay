package com.gionee.common.multidataSource;
/**  
* 上下文Holder  
*  
*/  

/**
 * @author dingyw
 *
 * 2015年2月6日
 */
@SuppressWarnings("unchecked")    
public class ContextHolder<T> {   
 
   @SuppressWarnings("rawtypes")
private static final ThreadLocal contextHolder = new ThreadLocal();   
      
    public static <T> void setContext(T context)   
    {   
        contextHolder.set(context);   
    }   
       
    public static <T> T getContext()   
    {   
        return (T) contextHolder.get();   
    }   
       
    public static void clearContext()   
    {   
        contextHolder.remove();   
    }   
} 