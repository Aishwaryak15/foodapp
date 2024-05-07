package com.cybage.service;

import com.cybage.model.Restaurant;
import com.cybage.model.User;

public interface RestaurentService {
	
	public Restaurant findByRestaurantEmailAndRestaurantPassword(String email, String password);

	public Restaurant findByRestaurantId(int restId);

	
	 
}
