package com.example.fruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Data
@Table(name = "`USER`")//用戶
public class User {

	@Id
	@Column(name = "USER_NUMBER") //用戶編號
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNumber;
	
	@Column(name = "USER_NAME")	 //用戶名稱
	private String userName;
	
	@Column(name = "PASSWORD")   //用戶密碼
	private String password;
}
