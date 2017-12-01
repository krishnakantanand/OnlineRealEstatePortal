package com.neu.edu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Seller;
import com.neu.edu.pojo.User;

public class SellerDAO extends DAO{

	public SellerDAO(){
		
	}
	
	public Seller createSeller(String userName,String password,String firstName,
			String lastName,String emailID,int phoneNumber)
	throws AdException{
		
		 try {
	            begin();
	            System.out.println("inside DAO");
	          
	            Seller seller=new Seller();
	            User user = new User();
	            
	            user.setUserName(userName);
	            user.setPassword(password);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setEmailID(emailID);
	            user.setPhoneNumber(phoneNumber);
	            user.setRole("Seller");	            
	            seller.setUser(user);
	            
	            getSession().save(user);
	            getSession().save(seller);
	            
	            commit();
	            return seller;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating seller: " + e.getMessage());
	        }
}
	public User get(String userName, String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName = :userName and password = :password");
            q.setString("userName", userName);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            
            commit();
            close();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }
	 public void save(Seller seller) throws AdException {
	        try {
	            begin();
	            getSession().update(seller);
	            commit();
	            close();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not save the seller", e);
	        }
	    }
	 
	 public Seller saveInSession(Seller seller){
		 
		 try{
			 begin();
			 seller=getSession().get(Seller.class,1);
			 
			 return seller;
			 
		 }
		 catch(HibernateException e){
			 
		 }finally{
			 close();
		 }
		 return null;
	 }
	 
	 public Seller getSellerByUserId(int sellerId){
		 
		 try{
			 begin();
			 Query q = getSession().createQuery("from Seller where sellerID = :sellerId");
			 q.setInteger("sellerId", sellerId);
			 Seller s = (Seller)q.uniqueResult();
			 
			 return s;
			 
		 }
		 catch(HibernateException e){
			 
		 }finally{
			 close();
		 }
		 return null;
		 
	 }
}
