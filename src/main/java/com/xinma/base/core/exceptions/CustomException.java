package com.xinma.base.core.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.xinma.base.core.error.SystemError;

/**
 * 系统自定义异常，继承自RuntimeException
 * 
 * @author Alauda
 *
 * @date 2016年5月19日
 *
 */
public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -772721964656196127L;

	/**
	 * 系统错误代码
	 */
	private String error;

	/**
	 * 系统错误参数
	 */
	private Object[] params;

	public String getErrorCode() {
		return error;
	}

	public void setErrorCode(String errorCode) {
		this.error = errorCode;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            异常描述信息
	 * @param error
	 *            错误代码
	 * @param params
	 *            错误信息需要的参数
	 */
	public CustomException(String message, SystemError error, Object... params) {
		super(message);
		this.error = error.value();
		this.params = params;
	}

	/**
	 * 获取Exception stack trace 信息
	 * 
	 * @param ex
	 * @return
	 */
	public static String getExceptionStackTrace(Throwable ex) {
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
