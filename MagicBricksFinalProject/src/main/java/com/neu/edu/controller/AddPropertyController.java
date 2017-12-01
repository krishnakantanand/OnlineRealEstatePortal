package com.neu.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.DAO.PropertyDAO;
import com.neu.edu.DAO.SellerDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Property;
import com.neu.edu.pojo.Seller;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/property.htm")
public class AddPropertyController {

	@Autowired
	@Qualifier("propertyValidator")
	PropertyValidator validator;
	
	@Autowired
	@Qualifier("propertyDAO")
	PropertyDAO propertyDAO;
	
	@Autowired
	SellerDAO sellerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}

@RequestMapping(method=RequestMethod.POST)
public ModelAndView doSubmitAction(@RequestParam("location")String location,@RequestParam("propertyType")String
		propertyType,@RequestParam("propertyArea")String propertyArea,@RequestParam("description")String 
		description,@RequestParam("status")String status,HttpServletRequest request,HttpServletResponse response) throws Exception{

		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		Seller seller = (Seller)session.getAttribute("seller");
		
		
		try {           
                        
         propertyDAO.createProperty(user,seller,location, propertyType, propertyArea, description, status);
            
          } catch (AdException e) {
            System.out.println(e.getMessage());
        }
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    
}
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@RequestParam("location")String location,@RequestParam("propertyType")String
    		propertyType,@RequestParam("propertyArea")String propertyArea,@RequestParam("description")String 
    		description,@RequestParam("status")String status, HttpServletRequest request) { 
		System.out.println("in get property");
        return "homePageSeller"; 
    } 
}
