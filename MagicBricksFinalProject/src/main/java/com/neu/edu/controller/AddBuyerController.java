package com.neu.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.DAO.BuyerDAO;
import com.neu.edu.DAO.PropertyDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.Property;



@Controller
//@RequestMapping("/addBuyer.htm")
public class AddBuyerController {

	@Autowired
	@Qualifier("buyerValidator")
	BuyerValidator validator;
	
	@Autowired
	//@Qualifier("buyerDAO")
	BuyerDAO buyerDAO;
	
	@Autowired
	PropertyDAO propertyDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);	
	}
	
	@RequestMapping(value="/addBuyer.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@Valid @ModelAttribute("buyer") Buyer buyer, BindingResult result){
		
		validator.validate(buyer,result);
		if (result.hasErrors()) {
			return "addBuyerForm";
		}
		try {
						
			buyerDAO.createBuyer(buyer.getUser().getUserName(),buyer.getUser().getPassword(),
					buyer.getUser().getFirstName(),buyer.getUser().getLastName(),
					buyer.getUser().getEmailID(),buyer.getUser().getPhoneNumber());
				
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedBuyer";
	}
	
	@RequestMapping(value="/addBuyer.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("buyer") Buyer buyer, BindingResult result) {

		return "addBuyerForm";
	}

	@RequestMapping(value="logout.htm",method= RequestMethod.POST)
	public String logout(@ModelAttribute("buyer")Buyer buyer, HttpServletRequest request) {
	    request.getSession().invalidate();
	    return "../index";
	  }
	
}
