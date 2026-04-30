package model;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CoffeeDAO {
   public List<Coffee>  getAllCoffees(){
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   return mgr.createNamedQuery("Coffee.findAll").getResultList();
   }
   
   public boolean insertCoffee(Coffee cf) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		  mgr.persist(cf); 
		  mgr.getTransaction().commit();
		  return true;
	   }catch(Exception ex) {
		   mgr.getTransaction().rollback();
		   System.out.println("Insert Coffee error "+ex.getMessage());
	   }
	   return false;
   }
   public boolean updateCoffee(String cname,Coffee cof) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		  Coffee found = mgr.find(Coffee.class, cname);
		  if(found==null) {
			  System.out.println(cname+" coffee name not found");
			  return false;
		  }
		  found.setPrice(cof.getPrice());
		  found.setSales(cof.getSales());
		  found.setSupId(cof.getSupId());
		  found.setTotal(cof.getTotal());
		  mgr.merge(found);
		  mgr.getTransaction().commit();
		  return true;
	   }catch(Exception ex) {
		   mgr.getTransaction().rollback();
		   System.out.println("Update Coffee error "+ex.getMessage());
	   }
	   return false;
   }
   public boolean deleteCoffee(String cname) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		  Coffee found = mgr.find(Coffee.class, cname);
		  if(found==null) {
			  System.out.println(cname+" coffee name not found");
			  return false;
		  }		  
		  mgr.remove(found);
		  mgr.getTransaction().commit();
		  return true;
	   }catch(Exception ex) {
		   mgr.getTransaction().rollback();
		   System.out.println("Delete Coffee error "+ex.getMessage());
	   }
	   return false;
   }
   
}
