package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.DAO.SellerDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.Seller;

@Controller

public class AddSellerController {

	@Autowired
	@Qualifier("sellerValidator")
	SellerValidator validator;
	
	@Autowired
	//@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);	
	}
	

	@RequestMapping(value="/addSeller.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@Valid @ModelAttribute("seller") Seller seller, BindingResult result
			,HttpServletRequest request){		
		
		validator.validate(seller, result);
		if (result.hasErrors()) {
			return "addSellerForm";
		}
		try {
			
			//SellerDAO sellerDAO = new SellerDAO();
			HttpSession session = request.getSession();
			
			sellerDAO.createSeller(seller.getUser().getUserName(),seller.getUser().getPassword(),
					seller.getUser().getFirstName(),seller.getUser().getLastName(),
					seller.getUser().getEmailID(),seller.getUser().getPhoneNumber());
				
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedSeller";
	}
	
	@RequestMapping(value="/addSeller.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("seller") Seller seller, BindingResult result) {

		return "addSellerForm";
	}

	@RequestMapping(value="logoutSeller.htm",method= RequestMethod.POST)
	public String logout(@ModelAttribute("seller")Seller seller, HttpServletRequest request) {
	    request.getSession().invalidate();
	    return "../index";
	  }
}

