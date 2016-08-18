package com.xinma.base.core.exceptions;

import com.xinma.base.core.error.CustomError;

/**
 * Serlet 请求参数不正确，抛出自定义异常
 * 
 * @author Alauda
 *
 * @date 2016年5月19日
 *
 */
public class BadInputException extends CustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5711716979034824583L;

	public BadInputException() {
		super();
	}

	public BadInputException(String message) {
		super(message);
	}

	public BadInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadInputException(Throwable cause) {
		super(cause);
	}

	public BadInputException(String message, CustomError code, String... params) {
		super(message, code, params);
	}

	public BadInputException(Throwable cause, CustomError error, String... params) {
		super(cause, error, params);
	}
}
