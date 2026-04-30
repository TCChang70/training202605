package demo.springmvc.model;

import javax.persistence.*;

@Entity              // 宣告此類別對應一張資料庫表格
@Table(name = "mvproduct")  // 指定表格名稱（預設用類別名稱）
public class Product {
	@Id
    private String id;      // 商品編號，如 "p01"
    private String name;    // 商品名稱
    private String photo;   // 圖片路徑，如 "images/p1.jpg"
    private double price;   // 價格

    // 無參數建構子（Hibernate 反射時需要）
    public Product() {}

    // 全參數建構子（方便初始化假資料）
    public Product(String id, String name, String photo, double price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.price = price;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    // Getter / Setter（省略，標準 JavaBean 格式）
    // getId(), setId(), getName(), setName(), getPhoto(), setPhoto(), getPrice(), setPrice()
    
}