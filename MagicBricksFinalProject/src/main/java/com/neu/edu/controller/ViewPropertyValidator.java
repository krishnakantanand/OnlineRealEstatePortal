package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Property;
import com.neu.edu.pojo.Seller;

public class ViewPropertyValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Property.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		Property property = (Property)obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location","error.invalid","Location is required");
	}

	
}
