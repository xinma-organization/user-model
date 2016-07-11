package com.xinma.base.core.client;

/**
 * 扫码客户端操作系统环境定义
 * 
 * @author zhangyongyi
 *
 */
public enum ClientOS {

	/**
	 * 0:其他系统
	 */
	Others(0, "其他"),

	/**
	 * 1:安卓
	 */
	Android(1, "安卓"),

	/**
	 * 2:苹果
	 */
	Iphone(2, "苹果"),

	/**
	 * 3:塞班
	 */
	Symbian(3, "塞班"),

	/**
	 * 4:黑莓
	 */
	BlackBerry(4, "黑莓"),

	/**
	 * 5:WP(Windows Phone)
	 */
	Windows(5, "WP");

	Integer value = 0;

	String remark;

	ClientOS(Integer value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public Integer getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	public static ClientOS valueOf(int value) {
		switch (value) {
		case 0:
			return Others;
		case 1:
			return Android;
		case 2:
			return Iphone;
		case 3:
			return Symbian;
		case 4:
			return BlackBerry;
		case 5:
			return Windows;

		default:
			return Others;
		}
	}

}
