package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.DAO.BuyerDAO;
import com.neu.edu.DAO.SellerDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.Property;
import com.neu.edu.pojo.Seller;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("loginseller.htm")
public class SellerLoginController {

	@Autowired
	@Qualifier("sellerLoginValidator")
	SellerLoginValidator validator;
	
	@Autowired
	SellerDAO sellerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) { 
		binder.setValidator(validator);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction( @ModelAttribute("seller") Seller seller, BindingResult result,
			HttpServletRequest request,Model model){
		
		validator.validate(seller, result);
		if (result.hasErrors()) {
			return "loginSeller";
		}
		try {
			HttpSession session = request.getSession();
			User user = sellerDAO.get(seller.getUser().getUserName(), seller.getUser().getPassword());
			
			if(user!=null){				
				
				System.out.println("User ID"+user.getUserId());		
			
				session.setAttribute("user", user);
				session.setAttribute("seller", user.getSeller());
				
				return "homePageSeller";
			}
			else {
				return "loginSeller";
			}
				
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("seller") Seller seller, BindingResult result) {

		return "loginSeller";
	}
			
}
