/**
 * 
 */
package com.gionee.common.utils;

import java.util.Date;

import com.gionee.common.exception.BizException;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author zhanggq
 *
 *         2017年6月21日
 */
public class DateUtils {
	private final static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getFormatSubmitTime(Date date) {
		return sf.format(date);
	}
	
	public static Date getParseTime(String text) throws BizException {
		try{
			return sf.parse(text);
		}catch(Exception e) {
			throw new BizException("parse time error");
		}
		
	}
}
