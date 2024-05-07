package com.cybage.service;

import java.util.List;

import com.cybage.exception.CustomException;
import com.cybage.model.User;

public interface UserService {
	public User saveUser(User user);	
	public void deleteUser(int userId);
	public List<User> findAllUsers();
	public User findByUserEmailAndUserPassword(String userEmail, String userPassword);
	User findByUserEmail(String email);
	
}
