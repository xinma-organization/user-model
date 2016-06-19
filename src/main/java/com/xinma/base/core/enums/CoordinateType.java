package com.xinma.base.core.enums;

/**
 * 坐标系类别，不同坐标系可以通过API相互转换
 * 
 * @author Hoctor
 *
 */
public enum CoordinateType {
	/**
	 * 即地球坐标系，国际上通用的坐标系。设备一般包含GPS芯片或者北斗芯片获取的经纬度为WGS84地理坐标系,
	 * 谷歌地图采用的是WGS84地理坐标系（中国范围除外）;
	 */
	WGS84("w"),

	/**
	 * GCJ02坐标系：即火星坐标系，是由中国国家测绘局制订的地理信息系统的坐标系统。由WGS84坐标系经加密后的坐标系。
	 * 谷歌中国地图、阿里云地图API和腾讯搜搜中国地图、高德MapABC地图API采用的是GCJ02地理坐标系
	 */
	GCJ02("g"),

	/**
	 * BD09坐标系：即百度坐标系，GCJ02坐标系经加密后的坐标系,百度地图API采用BD09坐标系
	 */
	BD09("b");

	String type;

	CoordinateType(String type) {
		this.type = type;
	}

	public String getValue() {
		return type;
	}
}
