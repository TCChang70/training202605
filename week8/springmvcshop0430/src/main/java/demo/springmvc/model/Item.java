package demo.springmvc.model;

//Item 是購物車中的一筆記錄：「哪個商品」買了「幾件」
public class Item {
 private Product product;  // 關聯的商品物件
 private int quantity;     // 購買數量

 public Item() {}

 public Item(Product product, int quantity) {
     this.product = product;
     this.quantity = quantity;
 }

 public Product getProduct() {
	return product;
 }

 public void setProduct(Product product) {
	this.product = product;
 }

 public int getQuantity() {
	return quantity;
 }

 public void setQuantity(int quantity) {
	this.quantity = quantity;
 }

 // Getter / Setter 省略
 
}
