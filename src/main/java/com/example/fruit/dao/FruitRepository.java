package com.example.fruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fruit.entity.Fruit;
//DAO
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
