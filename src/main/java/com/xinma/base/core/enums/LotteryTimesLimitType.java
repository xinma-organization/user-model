package com.xinma.base.core.enums;

/**
 * 抽奖次数限制类型定义
 * 
 * @author zhangyongyi
 *
 */
public enum LotteryTimesLimitType {

	/**
	 * 0:每人限抽奖次数
	 */
	LimitByPerMember(0, "每人限抽奖次数"),

	/**
	 * 1:每人每天限抽奖次数
	 */
	LimitByPerMemberOneDay(1, "每人每天限抽奖次数");

	Integer value = 0;

	String remark;

	LotteryTimesLimitType(Integer value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public Integer getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

}
