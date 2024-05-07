package com.cybage.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.CustomException;
import com.cybage.model.User;
import com.cybage.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/food-delivery")
public class UserController {
	static Logger logger=LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
		
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		//logger.info("Customer "+user.getUserName()+" logged in");
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws CustomException{
		System.out.println("work_done");
		logger.info("Customer "+user.getUserEmail()+" logged in");
		User userLogin = userService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		
		if(user.getUserEmail().equals("admin") && user.getUserPassword().equals("admin@123")) {
			//logger.error("customer" +user.getUserName()+"Logged in with wrong crediantials");
			logger.info("Customer "+user.getUserEmail()+" logged in");
			System.out.println("work_1");
			return new ResponseEntity<>("Admin logged in", HttpStatus.OK);
		}else if(userLogin == null) {
			System.out.println("work_2");
			return new ResponseEntity<>("Email or password is wrong", HttpStatus.NOT_FOUND);
		}else  {
			System.out.println("work_3");			
			return new ResponseEntity<>(userLogin,HttpStatus.OK);		
		}
		}	
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> list =userService.findAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted",HttpStatus.OK);
	}
	


}
