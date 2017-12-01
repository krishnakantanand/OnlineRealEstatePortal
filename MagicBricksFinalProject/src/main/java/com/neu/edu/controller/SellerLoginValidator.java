package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Seller;


public class SellerLoginValidator implements Validator{

	
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Seller.class);
	}

	
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		Seller seller = (Seller) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName", "error.invalid", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "error.invalid", "Password Required");
       
	}

}
