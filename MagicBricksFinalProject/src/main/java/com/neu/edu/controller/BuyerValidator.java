package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Buyer;

public class BuyerValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Buyer.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Buyer buyer = (Buyer) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName","error.invalid","UserName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password","error.invalid","Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.firstName","error.invalid","First Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.lastName","error.invalid","Last Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.emailID","error.invalid","Email ID is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.phoneNumber","error.invalid","Phone Number is required");
		
	
	}

	
}
