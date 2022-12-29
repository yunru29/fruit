package com.example.fruit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fruit.dao.DetailRepository;
import com.example.fruit.dao.FruitRepository;
import com.example.fruit.dao.OrderRepository;
import com.example.fruit.entity.Detail;
import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Order;

@Service
public class FruitService {

	@Autowired
	private FruitRepository fruitRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DetailRepository detailRepository;
	
	public List<Fruit> findAll(){
		return this.fruitRepository.findAll();
	}
	
	@Transactional
	
	public Integer addOrder(List<Detail> list){
		if (list == null || list.isEmpty()) {
			return -1;
		}
		int total = 0;
		Order order = new Order();
		order.setUserName("王小明");
		orderRepository.save(order);//新增訂單
		for (Detail detail : list) { 
			Optional<Fruit> optional = fruitRepository.findById(detail.getProductNumber());//取單筆
			if (optional.isPresent()) { 
				Fruit fruit = optional.get();
				Integer price = fruit.getProductPrice();
				Integer quantity = detail.getQuantity();
				total += price * quantity;		
				detail.setOrderNumber(order.getOrderNumber());
				detailRepository.save(detail);//新增明細
			} else {
				throw new RuntimeException("無此商品");
			}
		}
		return total;
	}
}
