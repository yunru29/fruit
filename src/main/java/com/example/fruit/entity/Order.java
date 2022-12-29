package com.example.fruit.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity//vo
@Data  //lombok
@Table(name = "`ORDER`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_NUMBER")	//訂單編號
	private Integer orderNumber;
	
	@Column(name = "USERNAME")//產品編號
	private String userName;
	
	@Column(name = "ORDER_DATE", insertable = false)	//訂單日期
	private Date orderDate;
	
	@Column(name = "ORDER_STATUS", insertable = false)	//訂單狀態
	private Integer orderStatus;
	

}
