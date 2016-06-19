package com.xinma.base.core.error;

/**
 * 标签异常状态
 * 
 * @author Hoctor
 *
 */
public enum IllegalTagError implements SystemError {
	/**
	 * 解码失败
	 */
	Common_Tag_000,

	/**
	 * tag没有上传到aliyun ots
	 */
	Common_Tag_001,

	/**
	 * hiddenCode与云端不一致
	 */
	Common_Tag_002;

	@Override
	public String value() {
		return this.toString();
	}

}
