package com.xinma.base.core.client;

import org.apache.commons.lang3.StringUtils;

/**
 * 扫码客户端环境分析工具类
 * 
 * @author zhangyongyi
 *
 */
public class ClientEnvironmentUtil {

	/**
	 * 从客户端请求的User-Agent信息中分析其操作系统类型
	 * 
	 * @param userAgent
	 *            HttpRequest的User-Agent字符串
	 * @return 返回客户端操作系统类型
	 */
	public static ClientOS getClientOSFormUserAgent(String userAgent) {
		if (StringUtils.isNotEmpty(userAgent)) {
			userAgent = userAgent.toLowerCase();
			if (StringUtils.containsIgnoreCase(userAgent, "windows ce")
					|| StringUtils.containsIgnoreCase(userAgent, "windows phone")) {
				return ClientOS.Windows;
			} else if (StringUtils.containsIgnoreCase(userAgent, "iphone")
					|| StringUtils.containsIgnoreCase(userAgent, "ipad")
					|| StringUtils.containsIgnoreCase(userAgent, "ipod")
					|| StringUtils.containsIgnoreCase(userAgent, "mac os")) {
				return ClientOS.Iphone;
			} else if (StringUtils.containsIgnoreCase(userAgent, "blackberry")) {
				return ClientOS.BlackBerry;
			} else if (StringUtils.containsIgnoreCase(userAgent, "symbian")) {
				return ClientOS.Symbian;
			} else if (StringUtils.containsIgnoreCase(userAgent, "android")) {
				return ClientOS.Android;
			}
		}

		return ClientOS.Others;
	}

	/**
	 * 从客户端请求的User-Agent信息中分析其扫码软件类型
	 * 
	 * @param userAgent
	 *            HttpRequest的User-Agent字符串
	 * @return 返回客户端操作软件的类型
	 */
	public static ClientSoftware getClientSoftwareFormUserAgent(String userAgent) {
		if (StringUtils.isNotEmpty(userAgent)) {
			userAgent = userAgent.toLowerCase();
			if (StringUtils.containsIgnoreCase(userAgent, "micromessenger")) {
				return ClientSoftware.Wechat;
			} else if (StringUtils.containsIgnoreCase(userAgent, "qqbrowser")
					|| StringUtils.contains(userAgent, "tencenttraveler")) {
				return ClientSoftware.QQ;
			} else if (StringUtils.containsIgnoreCase(userAgent, "safari")) {
				return ClientSoftware.Safari;
			} else if (StringUtils.containsIgnoreCase(userAgent, "ucweb")
					|| StringUtils.contains(userAgent, "ucbrowser")) {
				return ClientSoftware.UcBrowser;
			} else if (StringUtils.containsIgnoreCase(userAgent, "aliapp")) {
				return ClientSoftware.Taobao;
			}
		}

		return ClientSoftware.Others;
	}

}
