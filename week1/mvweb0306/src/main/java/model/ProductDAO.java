package model;
import java.util.*;
public class ProductDAO {
   static List<Product> data;

   public ProductDAO() {
	  data=new ArrayList<>();
   }
   
   public boolean addProduct(Product p) {
	   return data.add(p);
   }
   
   public List<Product> getAllProducts(){
	   return data;
   }
   
   public Product remove(String id) {
	   if(data.size()==0) {
		   return null;
	   }else {
		   Optional<Product> found= data.stream().filter(p->p.getId().equals(id)).findAny();
		   if(found.isPresent()) {
			   Product px=found.get();
			   data.remove(px);
			   return px;
		   }
		   else
			   return null;
	   }
   }
   public Product update(String id,Product pt) {
	   if(data.size()==0) {
		   return null;
	   }else {
		   Optional<Product> found= data.stream().filter(p->p.getId().equals(id)).findAny();
		   if(found.isPresent()) {
			   Product px=found.get();
			   px.setName(pt.getName());
			   px.setPrice(pt.getPrice());
			   return px;
		   }
		   else
			   return null;
	   }
   }
}
