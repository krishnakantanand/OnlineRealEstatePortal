package com.neu.edu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.User;



public class UserDAO extends DAO{

	 public UserDAO() {
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

	    public boolean loginCheck(String userName, String password)
	    throws AdException {
	    	
	    	try{
	    		begin();
	    		boolean userFound = false;
	    		String query = " from User where userName = :userName and password = :password";
	    		Query q = getSession().createQuery(query);
	    		q.setString("userName", userName);
	    		q.setString("password", password);
	    		List list = q.list();
	    		if ((list != null) && (list.size() > 0)) {
					userFound= true;
				}
	    		commit();
	    		close();
	    		return userFound;
	    	} catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + userName, e);
	        }
	    	
	    }
	    

	    public void delete(User user)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(user);
	            commit();
	            close();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + user.getUserName(), e);
	        }
	    }
	
}
