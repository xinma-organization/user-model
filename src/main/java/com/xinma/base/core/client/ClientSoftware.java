package com.xinma.base.core.client;

/**
 * 扫码客户端软件类型
 * 
 * @author zhangyongyi
 *
 */
public enum ClientSoftware {

	/**
	 * 0:其他软件
	 */
	Others(0, "其他"),

	/**
	 * 1:微信
	 */
	Wechat(1, "微信"),

	/**
	 * 2:QQ
	 */
	QQ(2, "QQ"),

	/**
	 * 3:Safari
	 */
	Safari(3, "Safari"),

	/**
	 * 4:UC浏览器
	 */
	UcBrowser(4, "UC浏览器"),

	/**
	 * 5:淘宝
	 */
	Taobao(5, "淘宝");

	Integer value = 0;

	String remark;

	ClientSoftware(Integer value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public Integer getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	public static ClientSoftware valueOf(int value) {
		switch (value) {
		case 0:
			return Others;
		case 1:
			return Wechat;
		case 2:
			return QQ;
		case 3:
			return Safari;
		case 4:
			return UcBrowser;
		case 5:
			return Taobao;

		default:
			return Others;
		}
	}

}
