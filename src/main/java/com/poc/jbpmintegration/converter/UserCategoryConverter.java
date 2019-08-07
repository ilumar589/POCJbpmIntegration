package com.poc.jbpmintegration.converter;

import com.poc.jbpmintegration.entity.UserCategory;

import java.beans.PropertyEditorSupport;

public class UserCategoryConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(UserCategory.fromValue(text));
	}
}
