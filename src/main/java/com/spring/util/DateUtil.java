package com.spring.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理类
 * 
 * @author Administrator
 * 
 */
public class DateUtil {

	private  static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");
	/**
	 * 格式化日期格式为"yyyy-MM-dd hh:mm:ss"的字符串
	 * @param date 需要格式化的日期
	 * @return
	 */
	public static String DateFormat(Date date) {
		return format.format(date);
	}
	/**
	 * 格式化日期格式为"yyyy-MM-dd hh:mm:ss"的字符串
	 * @param date 需要格式化的日期
	 * @return
	 */
	public static String DateFormat(java.sql.Date date) {
		return format.format(date);
	}
	/**
	 * 将字符串格式的日期转换为java.util.Date类型
	 * @param str
	 * @return
	 */
	public static Date StringToDate(String str){
		try {
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
