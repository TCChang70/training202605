package model;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ProductDAO {
   public List<Product> getAllProducts(){
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0320");
	   EntityManager mgr=factory.createEntityManager();
	   return mgr.createNamedQuery("Product.findAll",Product.class).getResultList();
   }
   
   public Product getProductById(int id) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0320");
	   EntityManager mgr=factory.createEntityManager();
	   Product p1=mgr.find(Product.class,id);
	   return p1;
   }
   
   public boolean addProduct(Product p) {
	   if(this.getProductById(p.getId())!=null) {
		   System.out.println("add product error Primary Key duplicate");
		   return false;
	   }
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0320");
	   EntityManager mgr=factory.createEntityManager();
	   
	   mgr.getTransaction().begin();
	   try {
		   mgr.persist(p);
		   mgr.getTransaction().commit();
		   return true;
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   mgr.getTransaction().rollback();		   
	   }
	   return false;
   }
   
   public boolean updateProduct(int id,Product p) {	   
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0320");
	   EntityManager mgr=factory.createEntityManager();
	   Product found=this.getProductById(id);
	   if(found==null)return false;
	   mgr.getTransaction().begin();
	   try {
		   found.setDescription(p.getDescription());
		   found.setProductname(p.getProductname());
		   found.setPrice(p.getPrice());
		   found.setStock(p.getStock());
		   mgr.merge(found);
		   mgr.getTransaction().commit();
		   return true;
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   mgr.getTransaction().rollback();		   
	   }
	   return false;
   }
   
   public boolean deleteProduct(int id) {
	   Product px=this.getProductById(id);
	   if(px==null) {
		   System.out.println("delete product error can't find id "+id);
		   return false;
	   }
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0320");
	   EntityManager mgr=factory.createEntityManager();
	   
	   mgr.getTransaction().begin();
	   try {
		   mgr.remove(px);;
		   mgr.getTransaction().commit();
		   return true;
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   mgr.getTransaction().rollback();		   
	   }
	   return false;
   }
}
