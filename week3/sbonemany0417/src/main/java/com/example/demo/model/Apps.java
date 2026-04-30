package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "app")
@EqualsAndHashCode(exclude = "mobile") 
@Data
public class Apps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "app_name", length = 255)
	private String appName;
	
	@Column(name = "app_size", length = 255)
	private long appSize;
	
     // JoinColumn會在多的表格建立一個mobile_id跟主表格的關聯欄位
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "mobile_id", nullable = false , referencedColumnName ="id")
	private Mobile mobile;
    
	public Apps() {}
	
	public Apps(String appName, long appSize, Mobile mobile) {
			
		this.appName = appName;
		this.appSize = appSize;
		this.mobile = mobile;
	}

	
	
}
 
