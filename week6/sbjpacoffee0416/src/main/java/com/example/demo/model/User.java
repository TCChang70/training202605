package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	@Id
	@Column(name="userid")
    Integer userId;
	@Column(name="username")
	String userName;
	@Column(name="userage")
	int userAge;
}
