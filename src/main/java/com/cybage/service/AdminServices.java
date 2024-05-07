package com.cybage.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.AdminRepo;
import com.cybage.model.Restaurant;

@Service
public class AdminServices
{

	@Autowired
	private AdminRepo AdminRepository;

	public void addresturant(Restaurant restaurant) {
		System.out.println(restaurant);
		AdminRepository.save(restaurant);
	}

	public List<Restaurant> getallresturant() {
		return AdminRepository.findAll();
	}

	public Restaurant getById(int id) {
		AdminRepository.findById(id);
		return AdminRepository.getById(id);
	}

	public void removeresturant(Restaurant restaurant) {
		AdminRepository.delete(restaurant);
		System.out.println("data deleted from Database");
	}
	
	public void updateresturant(Restaurant restaurant) {
		AdminRepository.save(restaurant);
	}


}
