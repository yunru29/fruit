package com.example.fruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
@Table(name = "`FRUIT`")//產品資料表
public class Fruit {
	@Id
	@Column(name = "PRODUCT_NUMBER")//產品編號
	private Integer productNumber;
	
	@Column(name = "PRODUCT_NAME")	//產品名稱
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")	//產品單價
	private Integer productPrice;
}
