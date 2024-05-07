package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.RestaurentDao;
import com.cybage.model.Restaurant;
import com.cybage.model.User;

@Service
public class RestaurentServiceImpl implements RestaurentService {

	@Autowired
	private RestaurentDao restaurantDao;

	@Override
	public Restaurant findByRestaurantEmailAndRestaurantPassword(String email, String password) {

		return restaurantDao.findByRestaurantEmailAndRestaurantPassword(email, password);
	}

	@Override
	public Restaurant findByRestaurantId(int restId) {
		// TODO Auto-generated method stub
		return restaurantDao.findById(restId).get();
	}


}
