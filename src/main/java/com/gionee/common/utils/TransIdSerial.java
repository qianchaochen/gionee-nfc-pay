package com.gionee.common.utils;

import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dingyw
 * TransIdSerial组成规则：token类型XXX(3位)+17位时间(yyyyMMddHHmmss)+4位（随机递增数,从0001到9999）+3位主机IP第三段+5位扰乱码+16位随机码(
 * 
 * 
 * 业务类型默认填写1000，流水性质默认填写10
 * 2015年2月9日
 */
public class TransIdSerial {
	
	Logger log = LoggerFactory.getLogger(getClass());
	// 最大数字
	private static final int MAX = 9999;
	// 数字长度
	private static final int NUMLEN = 4;

	private static TransIdSerial instance = null;
	private String lastTime = "";
	private int lastNo = 0;
	private int baseNum = 10000;
	private static final int seqLen = 3;//3位IP长度
	
	public TransIdSerial() {

	}

	private static String getSerialStringByNum(int base, int value) {
		String num = new Integer(base + value).toString();

		return num.substring(1);
	}
	/**
	 * 根据当前时间产生一个新的序列号
	 * 
	 * @param sourceId
	 * @return
	 */
	public static synchronized String genRandomSeqId() {
		Date curTime = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //到毫秒

		if (instance == null) {
			instance = new TransIdSerial();
			instance.lastNo = 0;
			instance.baseNum = (int) Math.pow(10, NUMLEN);
			instance.lastTime = s.format(curTime);
		}
		String now = s.format(curTime);

		if (now.compareTo(instance.lastTime) > 0) {
			// 当前时间大于上一次记录时间，表示可以开始新的计数
			instance.lastNo = 1;
			instance.lastTime = now;
			return now;
		}

		if (now.compareTo(instance.lastTime) < 0) {
			// 当前时间小于上一次的记录时间，表示上一秒有超过10000个流水号生成
			now = instance.lastTime;
		}

		int serialNo = instance.lastNo + 1;
		if (serialNo <= MAX) {
			// 当前没有超过最大允许流水号，返回上一个流水号+1作为新的流水号
			instance.lastNo = serialNo;
			return now;
		}

		try {
			Date last = s.parse(now);
			Calendar cal = Calendar.getInstance();
			cal.setTime(last);
			cal.add(Calendar.SECOND, 1);
			Date endTime = cal.getTime();
			String endStr = s.format(endTime);
			instance.lastNo = 1;
			instance.lastTime = endStr;
			return endStr;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}
	public static String genSeqId(String seqType,String nonce) { //指定三个参数时的流水号
		
		String now=genRandomSeqId();//生成17位时间，并设置SeqIdSerial的baseNum、lastNo，提供生成随机数的条件
		String hostIP = getHostIP4Part();
		int len = seqLen - hostIP.length(); //如果ip第三位不够3位长度，则生成随机数字填补
		hostIP = hostIP +  generateRandomString(len);
		String str = seqType+ now
				+ getSerialStringByNum(instance.baseNum, instance.lastNo) +hostIP+nonce;//拼接流水号
		return str;
	}

	public static String genSeqId(String seqType){//指定前缀时的流水号,必须是三位
		String seq= genSeqId(seqType,RandomStringUtils.randomAlphanumeric(5)); //5位随机码
		return seq+"-"+RandomStringUtils.randomAlphanumeric(16);
	}

	
	public static String generateRandomString(int len) {
		final char[] mm = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9' };

		StringBuffer sb = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < len; i++) {
			sb.append(mm[random.nextInt(mm.length)]);
		}
		return sb.toString();

	}
	public static void main(String[] args) {
		/*String accessToken="10120150213151243475004014410010-f00d007a11a590da9f0a46501df91424";
		validate(accessToken);*/
		
		for (int i = 0; i < 9999; i++) {
			System.out.println("Get SeqId=" + genSeqId("101")); // 第一种调用方法
			/*System.out.println("Get SeqId=" + genSeqId(CommonConstant.SEQ_TYPE.PUTAO.getValue()));*/ //第二种调用方法
		}
	}
	
	/**如果是分布式部署应用，生成的流水号加入IP的第三个字段，防止流水号冲突
	 * @return
	 */
	public static String getHostIP4Part(){
		String hostIP4Part=null;
		try {
			String addr = InetAddress.getLocalHost().getHostAddress();
			
			if(addr==null){
				hostIP4Part = "1.0.0.0"	;
			}
			else {
				hostIP4Part = addr.split("\\.")[3];
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hostIP4Part;
	}
}
