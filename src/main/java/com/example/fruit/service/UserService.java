package com.example.fruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fruit.dao.UserRepository;
import com.example.fruit.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public String register(User user){
		if (user == null) {
			return "註冊失敗";
		}
		String username = user.getUserName();
		if (username == null || username.isEmpty()) {
			return "註冊失敗";
		}
		
		String password = user.getPassword();
		if (password == null || password.isEmpty()) {
			return "註冊失敗";
		}
		
		userRepository.save(user);
		
		return "註冊成功";
	}
}
