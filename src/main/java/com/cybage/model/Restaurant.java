package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurent")
public class Restaurant
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restId;
	@Column
	private String restaurantName;
	@Column
	private String restaurantUserName;
	@Column
	private String restaurantPassword;
	@Column
	private String restaurantEmail;
	@Column
	private int attemptCount;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "restaurant")
	private List<FoodMenus> foodMenus;

	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restId, String restaurantName, String restaurantUserName, String restaurantPassword,
			String restaurantEmail, int attemptCount, Address address) {
		super();
		this.restId = restId;
		this.restaurantName = restaurantName;
		this.restaurantUserName = restaurantUserName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.attemptCount = attemptCount;
		this.address = address;
	}

	public Restaurant(String restaurantName, String restaurantUserName, String restaurantPassword,
			String restaurantEmail, int attemptCount, Address address) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantUserName = restaurantUserName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.attemptCount = attemptCount;
		this.address = address;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantUserName() {
		return restaurantUserName;
	}

	public void setRestaurantUserName(String restaurantUserName) {
		this.restaurantUserName = restaurantUserName;
	}

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public int getAttemptCount() {
		return attemptCount;
	}

	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restaurantName=" + restaurantName + ", restaurantUserName="
				+ restaurantUserName + ", restaurantPassword=" + restaurantPassword + ", restaurantEmail="
				+ restaurantEmail + ", attemptCount=" + attemptCount + ", address=" + address + "]";
	}
	
	

}
