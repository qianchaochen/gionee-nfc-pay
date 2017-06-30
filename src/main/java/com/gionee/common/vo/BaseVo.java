package com.gionee.common.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author dingyw
 *
 * 2015年1月8日
 */
public class BaseVo {
	public String toString(){
		try{
			return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
		}catch(Throwable e){
			return getClass().getName();
		}
	}

}
