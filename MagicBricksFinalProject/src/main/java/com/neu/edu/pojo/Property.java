package com.neu.edu.pojo;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Property generated by hbm2java
 */
@Entity
@Table(name = "property", catalog = "project")
public class Property implements java.io.Serializable {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long propertyID;	
	
	private Seller seller;
	private String location;
	private String propertyType;
	private String propertyArea;
	private String description;
	private String status;
	private Set<Buyer> buyers = new HashSet(0);

	public Property() {
	}

	public Property(long id, Seller seller, String location, String propertyType, String propertyArea,
			String description, String status) {
		this.propertyID = id;
		//this.seller = seller;
		this.location = location;
		this.propertyType = propertyType;
		this.propertyArea = propertyArea;
		this.description = description;
		this.status = status;
	}

	public Property(long id, Seller seller, String location, String propertyType, String propertyArea,
			String description, String status, Set<Buyer> buyers) {
		this.propertyID = id;
		//this.seller = seller;
		this.location = location;
		this.propertyType = propertyType;
		this.propertyArea = propertyArea;
		this.description = description;
		this.status = status;
		this.buyers = buyers;
	}
	public Property(Seller seller,String location, String propertyType, String propertyArea,
			String description, String status){
		//this.seller = seller;
		this.location = location;
		this.propertyType = propertyType;
		this.propertyArea = propertyArea;
		this.description = description;
		this.status = status;
	}

	
	
//	@AttributeOverrides({
//			@AttributeOverride(name = "propertyID", column = @Column(name = "propertyID", nullable = false)),
//			@AttributeOverride(name = "seller", column = @Column(name = "seller")) })
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "propertyID", unique = true, nullable = false)
	public long getPropertyId() {
		return this.propertyID;
	}

	public void setPropertyId(long id) {
		this.propertyID = id;
		}
	


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller")
	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Column(name = "location", nullable = false, length = 45)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "propertyType", nullable = false, length = 45)
	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Column(name = "propertyArea", nullable = false)
	public String getPropertyArea() {
		return this.propertyArea;
	}

	public void setPropertyArea(String propertyArea) {
		this.propertyArea = propertyArea;
	}

	@Column(name = "description", nullable = false, length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "properties")
	public Set<Buyer> getBuyers() {
		return this.buyers;
	}

	public void setBuyers(Set<Buyer> buyers) {
		this.buyers = buyers;
	}

}
