package com.example.fruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // vo
@Data // lombok
@Table(name = "`DETAIL`")
public class Detail {

	@Id
	@Column(name = "DETAIL_NUMBER") // 明細編號
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detailNumber;

	@Column(name = "ORDER_NUMBER") // 訂單編號
	private Integer orderNumber;

	@Column(name = "PRODUCT_NUMBER") // 產品編號
	private Integer productNumber;

	@Column(name = "QUANTITY") // 購買數量
	private Integer quantity;

}
