package com.xinma.base.core.enums;

/**
 * 积分获取或使用状态
 * 
 * @author Hoctor
 *
 */
public enum PointDetailStatus {
	// 0 ~ 9 为积分获取状态
	/**
	 * 0:扫码送积分
	 */
	GainFromScanTag(0),

	/**
	 * 1:活动抽奖送积分
	 */
	GainFromWinLottery(1),

	/**
	 * 2:会员签到送积分
	 */
	GainFromUserSingIn(2),

	// 以下为积分消耗状态
	/**
	 * 抽奖消耗
	 */
	ConsumeForLottery(10);

	int status;

	PointDetailStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return status;
	}
}
