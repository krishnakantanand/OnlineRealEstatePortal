package com.neu.edu.DAO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.edu.Exception.AdException;
import com.neu.edu.pojo.Buyer;
import com.neu.edu.pojo.Property;
import com.neu.edu.pojo.Seller;
import com.neu.edu.pojo.User;


public class PropertyDAO extends DAO{

	public PropertyDAO(){
		
	}
	
	public Property createProperty(User user,Seller seller,String location,String propertyType,
			String propertyArea, String description, String status)
	throws AdException{
		
		 try {
	            begin();
	            System.out.println("inside DAO");
	             
	            Property property = new Property();	           
	           
	            property.setLocation(location);
	            property.setPropertyType(propertyType);
	            property.setPropertyArea(propertyArea);
	            property.setDescription(description);
	            property.setStatus(status);
	            
	            property.setSeller(seller);
	            seller.getProperties().add(property);
	            
	            getSession().save(property);
	            commit();
	            close();
	            return property;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while creating Property: " + e.getMessage());
	        }
}
	public Set searchProperties(String location) throws AdException{
		
		try{
			begin();
			Query query = getSession().createQuery("from Property where location = :location");
			query.setString("location",location);
			//List propertyList = query.list();
			List pList = query.list();
			Set<Property> propertyList = new HashSet<Property>(pList);
			commit();
			close();
			System.out.println("Property List ");
			return propertyList;
		}
		catch(HibernateException e){
			rollback();
            throw new AdException("Could not list the properties", e);
		}
		
	}
	
	public void addInBuyerProperty(Buyer buyer) throws AdException{
		
		try{
			begin();
					
			getSession().saveOrUpdate(buyer);
			
			commit();
			close();
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while adding in buyer_property: " + e.getMessage());
        }
		
	}
	public List<Property> viewSellerProperty(Seller seller){
		
		try{
			begin();
			Query query = getSession().createQuery("from Property where seller = :seller");
			query.setInteger("seller",seller.getSellerID());
			
			List<Property> pList = (List<Property>)query.list();
			
			commit();
			close();
			
			return pList;
		}
		catch(HibernateException e){
			rollback();
			System.out.println(e);
		}
		return null;
	}
	
	public List<Buyer> viewBuyers(long propertyID) throws AdException {
		
		try{
			begin();
			Criteria criteria = getSession().createCriteria(Buyer.class);
			criteria=criteria.createCriteria("properties");
			criteria = criteria.add(Restrictions.eq("propertyId",propertyID));
			//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			List <Buyer> buyerList = criteria.list();
			//Set<Buyer> bList = new HashSet<Buyer>(buyerList);
			
			commit();
			close();
			return  buyerList;
		}
		catch(HibernateException e){
			rollback();
			System.out.println(e);
		}
		return null;
	}
}
