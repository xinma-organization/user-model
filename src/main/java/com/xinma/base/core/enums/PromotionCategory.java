package com.xinma.base.core.enums;

/**
 * 促销活动类型
 * 
 * @author zhangyongyi
 *
 */
public enum PromotionCategory {

	/**
	 * 0:普通促销活动
	 */
	Normal(0, "普通促销活动"),

	/**
	 * 1:积分抽奖活动
	 */
	Points_Lottery(1, "积分抽奖活动");

	Integer value = 0;

	String remark;

	PromotionCategory(Integer value, String remark) {
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
