package com.xinma.base.core.error;

public enum GeneralError implements CustomError {

	ThreadSleepInterruptedException("core-001", "thread sleep interrupted exception.");

	String value;

	String description;

	GeneralError(String value, String description) {
		this.value = value;
		this.description = description;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public String description() {
		return description;
	}

}
