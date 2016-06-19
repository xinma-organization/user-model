package com.xinma.base.core;

import java.util.Properties;

/**
 * 定义系统通用常量
 * 
 * @author Hoctor
 *
 */
public class CoreConstants {

	private final static Properties props = System.getProperties();

	private final static String openBrace = "{";
	private final static String closeBrace = "}";
	private final static String comma = ",";
	private final static String colon = ":";

	/**
	 * 获取系统行分隔符
	 * 
	 * @return 在 unix 系统中是＂/n＂
	 */
	public static String lineSeparator() {
		return "\r\n";
	}

	/**
	 * 获取系统文件分隔符
	 * 
	 * @return 在 unix 系统中是＂/＂ ,windows是＂\＂
	 */
	public static String fileSeparator() {
		return props.getProperty("file.separator");
	}

	/**
	 * 获取系统路径分隔符
	 * 
	 * @return 在 unix 系统中是＂:＂,windows中是＂;＂
	 */
	public static String pathSeparator() {
		return props.getProperty("path.separator");
	}

	/**
	 * 获取用户的当前工作目录
	 * 
	 * @return 用户的当前工作目录
	 */
	public static String userDirectory() {
		return props.getProperty("user.dir");
	}

	/**
	 * 左大括号字符
	 * 
	 * @return 左大括号字符
	 */
	public final static String openBrace() {
		return openBrace;
	}

	/**
	 * 右大括号字符
	 * 
	 * @return 右大括号字符
	 */
	public final static String closeBrace() {
		return closeBrace;
	}

	/**
	 * 逗号字符
	 * 
	 * @return 逗号字符
	 */
	public final static String comma() {
		return comma;
	}

	/**
	 * 冒号字符
	 * 
	 * @return 冒号字符
	 */
	public final static String colon() {
		return colon;
	}
}
