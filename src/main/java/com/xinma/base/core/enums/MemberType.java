package com.xinma.base.core.enums;

/**
 * 会员类型（会员系统的会员类型）
 * 
 * @author zhangyongyi
 *
 */
public enum MemberType {

	/**
	 * 0:所有会员
	 */
	AllMember(0, "所有会员"),

	/**
	 * 1:新注册会员
	 */
	NewMember(1, "新注册会员"),

	/**
	 * 2:老会员
	 */
	OldMember(2, "老会员");

	Integer value = 0;

	String remark;

	MemberType(Integer value, String remark) {
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
