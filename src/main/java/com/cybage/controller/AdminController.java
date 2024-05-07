package com.cybage.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.CustomException;
import com.cybage.model.Restaurant;
import com.cybage.service.AdminServices;
import com.cybage.service.RestaurentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/restaurant")
public class AdminController 
{
	@Autowired
	private RestaurentService restaurantService;
	
	@Autowired
	private AdminServices adminService;

	@PostMapping("/")
	public ResponseEntity<String> addresturant(@RequestBody Restaurant resturant) {
		adminService.addresturant(resturant);
		return new ResponseEntity<String>("resturant added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getAllresturant")
	public ResponseEntity<List<Restaurant>> getAllresturant() {
		return new ResponseEntity<List<Restaurant>>(adminService.getallresturant(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteresturant(@PathVariable int id) {
		Restaurant index = adminService.getById(id);
		adminService.removeresturant(index);
		return new ResponseEntity<String>("resturant record deleted successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getresturantById(@PathVariable int id) {
		Restaurant resturant = adminService.getById(id);
		return new ResponseEntity<Restaurant>(resturant, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateresturant(@RequestBody Restaurant resturant) {

		adminService.updateresturant(resturant);
		return new ResponseEntity<String>("Record updated successfully", HttpStatus.CREATED);
	}




@PostMapping("/login")
	public ResponseEntity<?> restaurantLogin(@RequestBody Restaurant restaurant) throws CustomException {
		System.out.println("manishRestLogin1");
		Restaurant loginRestaurant = restaurantService.findByRestaurantEmailAndRestaurantPassword(
				restaurant.getRestaurantEmail(), restaurant.getRestaurantPassword());
		if (loginRestaurant != null) {
			// logger1.info("Restaurant "+loginRestaurant.getRestaurantUserName()+" logged
			// in");
			//logger.info("Customer "+loginUser.getUserName()+" logged in");
			return new ResponseEntity<>(loginRestaurant, HttpStatus.OK);
		}
		if(loginRestaurant==null) {
			System.out.println("Null value");
		}
		throw new CustomException("Email or password is wrong");
	}

}
