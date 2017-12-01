package com.neu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.DAO.BuyerDAO;
import com.neu.edu.DAO.SellerDAO;
import com.neu.edu.DAO.UserDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Controller
@RequestMapping("/login.htm")
public class LoginController {

	@Autowired
	@Qualifier("loginValidator")
	LoginValidator validator;
	
	@Autowired
	BuyerDAO buyerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) { 
		binder.setValidator(validator);	
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction( @ModelAttribute("buyer") Buyer buyer, BindingResult result,
			HttpServletRequest request){
		System.out.println("calling do submit");
		validator.validate(buyer, result);
		if (result.hasErrors()) {
			return "login";
		}
		try {
			HttpSession session = request.getSession();
			
			User user = buyerDAO.get(buyer.getUser().getUserName(), buyer.getUser().getPassword());
			
			if(user!=null){

				session.setAttribute("user", user);
				session.setAttribute("buyer", user.getBuyer());
				
				return "homePageBuyer";
			}
			else {
				return "login";
			}
				
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("buyer") Buyer buyer, BindingResult result) {

		return "login";
	}
}
