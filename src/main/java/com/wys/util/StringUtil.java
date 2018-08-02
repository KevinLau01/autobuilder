package com.wys.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wys.config.SetupConfig;

/**
 * 字符串工具类
 * @author Yinglong Xu
 * @date 2012-2-16
 */
public class StringUtil {

	/**
	 * 首字母大写
	 * @param str
	 * @return String
	 */
	public static String capFirst(String str) {
		String firstC = str.substring(0, 1);
		return str.replaceFirst(firstC, firstC.toUpperCase());
	}

	/**
	 * java风格编程：驼峰式命名<br/>
	 * eg:user_name -> userName
	 * @param tableName
	 * @return String
	 */
	public static String javaStyle(String tableName) {
		String patternStr = "(_[a-z])";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(tableName);
		StringBuffer buf = new StringBuffer();
		while (matcher.find()) {
			String replaceStr = matcher.group();
			matcher.appendReplacement(buf, replaceStr.toUpperCase());
		}
		matcher.appendTail(buf);
		return buf.toString().replaceAll("_", "");
	}
	
	/**
	 * 处理：去掉前缀，驼峰式写法
	 * @param tableName
	 * @return String
	 */
	public static String javaStyleOfTableName(String tableName) {
//		System.out.println("javaStyleOfTableName tableName:"+tableName);
		String prefixs = SetupConfig.getInstance().getIgnorePrefix();
		String[] ps = prefixs.split(",");
		for (int i = 0; i < ps.length; i++) {
			if (tableName.startsWith(ps[i])) {
				tableName = tableName.replaceAll(ps[i], "");
			}
		}
		return StringUtil.javaStyle(tableName);
	}
	
	/**
	 * pojo class name
	 * @author xuyl
	 * @date 2013-1-7
	 * @param tableName
	 * @return
	 */
	public static String className(String tableName) {
		return capFirst(javaStyle(tableName));
	}

	/**
	 * is mapping table?
	 * @author yxm
	 * @date 2018-8-2
	 * @param tableName
	 * @return
	 */
	public static boolean isMappingTeble(String tableName) {
		if(tableName.endsWith("_mapping")){
			return  true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		String str="com.a.b";
//		System.out.println(str.replaceAll("\\.","\\\\"));
//	}

}
