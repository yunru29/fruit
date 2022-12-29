package com.example.fruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fruit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
