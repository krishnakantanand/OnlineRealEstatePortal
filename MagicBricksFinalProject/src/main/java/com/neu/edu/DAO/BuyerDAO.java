package com.neu.edu.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.Seller;
import com.neu.edu.pojo.User;

public class BuyerDAO extends DAO{

	public BuyerDAO(){
		
	}
	
	public Buyer createBuyer(String userName,String password,String firstName,
			String lastName,String emailID,int phoneNumber)
	throws AdException{
		
		 try {
	            begin();
	            	          
	            Buyer buyer=new Buyer();
	            User user = new User();
	            
	            user.setUserName(userName);
	            user.setPassword(password);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setEmailID(emailID);
	            user.setPhoneNumber(phoneNumber);
	            user.setRole("Buyer");
	            buyer.setUser(user);
	            
	            getSession().save(user);
	            getSession().save(buyer);
	            
	            commit();
	            close();
	            return buyer;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating buyer: " + e.getMessage());
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
	
	public Buyer getBuyerById(int buyerId){
		 
		 try{
			 begin();
			 Query q = getSession().createQuery("from Buyer where buyerID = :buyerId");
			 q.setInteger("buyerId", buyerId);
			 Buyer b = (Buyer)q.uniqueResult();
			 commit();
			 return b;
			 
		 }
		 catch(HibernateException e){
			 
		 }finally{
			 close();
		 }
		 return null;
		 
	 }
}