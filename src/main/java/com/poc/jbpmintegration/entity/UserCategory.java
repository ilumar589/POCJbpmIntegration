package com.poc.jbpmintegration.entity;

import java.util.Arrays;

public enum UserCategory {
	ADMIN("Admin"), REQUESTER("Requester"), FIRST_APPROVER("First Approver"), SECOND_APPROVER("Second Approver"), THIRD_APPROVER("Third Approver");

	private String value;

	UserCategory(String value) {
		this.value = value;
	}

	public static UserCategory fromValue(String value) {
		for (UserCategory category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
