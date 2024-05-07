package com.cybage.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.dao.UserDao;
import com.cybage.exception.CustomException;
import com.cybage.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
	
	@Override
	public void deleteUser(int userId) {
		userDao.deleteById(userId);
	}

	@Override
	public User findByUserEmailAndUserPassword(String email, String password)  {
		User user = findByUserEmail(email);
		if(user==null){
			System.out.println("user not found");
		}
		if(user.getUserEmail().equals(email) && user.getUserPassword().equals(password))  {
			return user;
		}
		return null;
	}

	@Override
	public User findByUserEmail(String email) {
		if(userDao.findByUserEmail(email) == null) {
			return null;
		}else {
			return userDao.findByUserEmail(email);
		}		
	}



}
