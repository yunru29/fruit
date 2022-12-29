package com.example.fruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fruit.entity.Detail;
//DAO
public interface DetailRepository extends JpaRepository<Detail, String>{

//<型態,識別欄位>
//新刪修查
	
}
