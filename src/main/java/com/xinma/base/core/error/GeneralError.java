package com.xinma.base.core.error;

public enum GeneralError implements CustomError {

	ThreadSleepInterruptedException("common-threadsleep-interruptedexception", "catch exception when thread sleep.");

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
