package com.example.fruit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.fruit.entity.Detail;
import com.example.fruit.entity.Fruit;
import com.example.fruit.service.FruitService;


@RestController
@RequestMapping(path = {"/fruit"})
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	//列出所有產品資料
	@GetMapping("/findAll")
	public List<Fruit> findAll(){
		return fruitService.findAll();
	}
	//購買清單
	@PostMapping("/buy")
	public Map<String, Object> buy(@RequestBody List<Detail> list){ 
		Map<String, Object> respMap = new HashMap<>();
		try {
			int total = fruitService.addOrder(list);					
			respMap.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
			respMap.put("msg", "含有不存在的產品");
		}
		return respMap;
	}
}
