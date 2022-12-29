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
	//拿編號取出單價 判斷null
	public Integer addOrder(List<Detail> list){
		if (list == null || list.isEmpty()) {
			return -1;
		}
		int total = 0;
		Order order = new Order();
		order.setUserName("王小明");
		orderRepository.save(order);
		for (Detail detail : list) { 	//前端購買訂單 //每次拿出一筆detail
			Optional<Fruit> optional = fruitRepository.findById(detail.getProductNumber());	//值的容器 會回傳布林值
			if (optional.isPresent()) { //檢查值是否存在
				Fruit fruit = optional.get();
				Integer price = fruit.getProductPrice();//單價
				Integer quantity = detail.getQuantity();//數量
				total += price * quantity;		
				detail.setOrderNumber(order.getOrderNumber());
				detailRepository.save(detail);	
			} else {
				throw new RuntimeException("無此商品");
			}
		}
		return total;
	}
}
