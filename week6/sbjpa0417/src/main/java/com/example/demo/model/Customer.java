package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//對應資料庫表名稱
@Table(name="customer")
//啟用審計(Auditing)的實體中都必須註冊這個 Listener，否則是沒有效果
@EntityListeners(AuditingEntityListener.class)

@Data
public class Customer {
 
 @Id
 // 主鍵由數據庫自動維護(AUTO_INCREMENT)
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long id;
 
 @Column(name = "name")
 private String name;
 
 @Column(name = "age")
 private Short age;
 
 @Column(name = "create_by")
 private String createBy;
 
 @Column(name = "create_dt")
 // 自動創建時間
 @CreatedDate()
 private Date createDt;
 
 @Column(name = "modify_by")
 private String modifyBy;
 
 @Column(name = "modify_dt")
 // 修改時自動創建時間
 @LastModifiedDate
 private Date modifyDt;
 
 public Customer(){}
 
 public Customer(String name, Short age, String createBy){
     this.name = name;
     this.age = age;
     this.createBy = createBy;
 }
  
}

