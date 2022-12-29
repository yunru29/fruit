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
@Table(name = "`USER`")
public class User {

	@Id
	@Column(name = "USER_NUMBER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNumber;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
}
