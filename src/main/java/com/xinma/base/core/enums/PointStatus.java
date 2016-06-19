package com.xinma.base.core.enums;

/**
 * 积分状态(收益或者消耗)
 * 
 * @author Hoctor
 *
 */
public enum PointStatus {
	/**
	 * 0:收益积分
	 */
	Income(0),

	/**
	 * 消耗积分
	 */
	Consume(1);

	int status;

	PointStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return status;
	}
}
