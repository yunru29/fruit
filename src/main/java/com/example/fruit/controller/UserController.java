package com.example.fruit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruit.entity.User;
import com.example.fruit.service.FruitService;
import com.example.fruit.service.UserService;

@RestController
@RequestMapping(path = {"/user"}) //請求的位置
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Map<String, Object> register(@RequestBody User user){
		Map<String, Object> respMap = new HashMap<>();
		
		try {
			String result= userService.register(user);
			respMap.put("user",result);
		} catch (Exception e) {
			e.printStackTrace();
			respMap.put("msg", "請填寫正確資料");
		}
		return respMap;
	}
	
}
