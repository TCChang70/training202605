package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="USERNAME",length=80)
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String cellphone;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ADDRESS")
	private String address;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getCellphone() {
//		return cellphone;
//	}
//
//	public void setCellphone(String cellphone) {
//		this.cellphone = cellphone;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

}

