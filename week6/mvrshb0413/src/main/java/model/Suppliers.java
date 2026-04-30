package model;

import javax.persistence.*;

@Entity
@Table(name="suppliers")
public class Suppliers {
	@Id
	@Column(name="SUP_ID")
   int supId;
	@Column(name="SUP_NAME")
   String supName;
   String city;
   String street;
   String state;
   String zip;
   public int getSupId() {
	return supId;
   }
   public void setSupId(int supId) {
	this.supId = supId;
   }
   public String getSupName() {
	return supName;
   }
   public void setSupName(String supName) {
	this.supName = supName;
   }
   public String getCity() {
	return city;
   }
   public void setCity(String city) {
	this.city = city;
   }
   public String getStreet() {
	return street;
   }
   public void setStreet(String street) {
	this.street = street;
   }
   public String getState() {
	return state;
   }
   public void setState(String state) {
	this.state = state;
   }
   public String getZip() {
	return zip;
   }
   public void setZip(String zip) {
	this.zip = zip;
   }
   
}
