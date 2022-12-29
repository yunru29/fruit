package com.example.fruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fruit.entity.Order;


//DAO
public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
