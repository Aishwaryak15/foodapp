package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Restaurant;
import com.cybage.model.User;

public interface RestaurentDao extends JpaRepository<Restaurant, Integer> {

	Restaurant findByRestaurantEmailAndRestaurantPassword(String email,String password);
	
	
}
