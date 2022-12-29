package com.example.fruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;

@Entity//vo
@Data  //lombok
@Table(name = "`FRUIT`")
public class Fruit {
	@Id
	@Column(name = "PRODUCT_NUMBER")//產品編號
	private Integer productNumber;
	
	@Column(name = "PRODUCT_NAME")	//產品名稱
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")	//產品單價
	private Integer productPrice;
}
