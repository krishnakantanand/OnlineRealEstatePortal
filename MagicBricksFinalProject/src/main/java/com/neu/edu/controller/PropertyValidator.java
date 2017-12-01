package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Property;


public class PropertyValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Property.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Property property = (Property) obj;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location","error.invalid","Location is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyType","error.invalid","Property Type is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyArea","error.invalid","Property Area is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","error.invalid","Description is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status","error.invalid","Status is required");
				
	}
	

}
