package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import com.cybage.dto.FoodMenusResponseDTO;

import com.cybage.dao.FoodMenusDao;
import com.cybage.dto.FoodMenusRequestDTO;
import com.cybage.model.FoodMenus;
import com.cybage.model.Restaurant;

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

import com.cybage.service.FoodMenusService;
import com.cybage.service.RestaurentService;

@RestController
@RequestMapping("/food-menu")
@CrossOrigin("http://localhost:4200")
public class FoodController {
	@Autowired
	private FoodMenusService foodMenusService;
	
	@Autowired
	private FoodMenusDao foodMenusDao;
	
	@Autowired
	private RestaurentService restaurantService;
	
	@GetMapping("/{foodId}")
	public ResponseEntity<?> addFoodMenu(@PathVariable int foodId ,FoodMenus foodMenus) {
		return new ResponseEntity<>(foodMenusService.findById(foodId), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addFoodMenus/{restaurantId}")
	public ResponseEntity<?> addFoodMenus(@PathVariable int restaurantId, @RequestBody FoodMenus foodMenu) {
		Restaurant restaurant= restaurantService.findByRestaurantId(restaurantId);
		System.out.println(restaurant);
        System.out.println("restaurant id"+" "+restaurantId);
	   
		try {
			foodMenusService.insertNewFood(foodMenu, restaurant);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Food Item Not Added!!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(foodMenu, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateFoodMenu/{foodId}")
	public ResponseEntity<?> updateFoodMenu(@PathVariable int foodId, @RequestBody FoodMenus foodMenu) {
		FoodMenus foodItem = foodMenusService.updateFoodMenu(foodMenu, foodId);
		
		
			
		foodItem.setFoodName(foodMenu.getFoodName());
		foodItem.setFoodCategory(foodMenu.getFoodCategory());
		foodItem.setPrice(foodMenu.getPrice());
		foodItem.setOffer(foodMenu.getOffer());
			return new ResponseEntity<>(foodMenusDao.save(foodItem), HttpStatus.OK);
		
		
	}

	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<String> deleteFoodMenuById(@PathVariable int foodId) {
		try {
			foodMenusService.deleteFoodMenu(foodId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Enter Valid Food Menu", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Food Menu deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/allFoodMenus")
	public ResponseEntity<List<FoodMenus>> getAllFoodMenus() {
		return new ResponseEntity<List<FoodMenus>>(foodMenusService.findAllFoodMenus(), HttpStatus.OK);
	}

	@GetMapping("/getFoodByRestaurant/{restuarant_id}")
	public ResponseEntity<?> getAllFoodByRestaurant(@PathVariable int restuarant_id) {
		List<FoodMenus> foodItems = foodMenusService.getByRestaurantId(restuarant_id);
		return new ResponseEntity<>(foodItems, HttpStatus.OK);
	}
	
	@PutMapping("/removeOffer/{foodId}")
	public ResponseEntity<?> removeFoodOffer(@PathVariable int foodId, FoodMenusRequestDTO foodMenusRequestDTO) {
		FoodMenus foodItem = foodMenusService.findByFoodId(foodId);
		foodItem.setOffer(0);
		return new ResponseEntity<>(FoodMenusResponseDTO.fromEntity(foodMenusService.updateOffer(foodItem)), HttpStatus.OK);
	}

	@PutMapping("/updateOffer/{foodId}")
	public ResponseEntity<?> updateFoodOffer(@PathVariable int foodId, FoodMenusRequestDTO foodMenusRequestDTO) {
		FoodMenus foodItem = foodMenusService.findByFoodId(foodId);
		foodItem.setOffer(foodMenusRequestDTO.getOffer());
		return new ResponseEntity<>(FoodMenusResponseDTO.fromEntity(foodMenusService.updateOffer(foodItem)), HttpStatus.OK);
	}
	
	@GetMapping("/allOffers")
	public ResponseEntity<List<FoodMenus>> getAllFoodOffer() {
		return new ResponseEntity<List<FoodMenus>>(foodMenusService.findByOfferNot(0.0d), HttpStatus.OK);
	}
	
	@PostMapping("/addOffer")
	public ResponseEntity<?> addFoodOffer(FoodMenusRequestDTO foodMenusRequestDTO) {
		FoodMenus foodItem = foodMenusService.findByFoodId(foodMenusRequestDTO.getFoodId());
		foodItem.setOffer(foodMenusRequestDTO.getOffer());
		return new ResponseEntity<>(FoodMenusResponseDTO.fromEntity(foodMenusService.updateOffer(foodItem)), HttpStatus.OK);
	}
	
	@GetMapping("/getFood")
	public ResponseEntity<List<FoodMenus>> getAllFoodWithoutOffer() {
		return new ResponseEntity<List<FoodMenus>>(foodMenusService.findByOffer(0.0d), HttpStatus.OK);
	}
}
