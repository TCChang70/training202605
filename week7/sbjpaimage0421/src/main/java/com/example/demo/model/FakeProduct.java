package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="fakeproducts")
@Data
public class FakeProduct {
	@Id
	Integer id;
	String title;
	@Column(name = "description", length = 1024)
	String description;
	String category;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity= Rating.class)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
	Rating rating;
	@Lob
    @Column(name = "picture", length = Integer.MAX_VALUE, nullable = true)
    private byte[] picture;
	double price;
	String image;
}