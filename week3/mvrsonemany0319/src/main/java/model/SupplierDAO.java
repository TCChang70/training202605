package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SupplierDAO {
	 public List<Supplier>  getAllSuppliers(){
		   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrsonemany0319");
		   EntityManager mgr=factory.createEntityManager();
		   List<Supplier> data=mgr.createQuery("select sp from Supplier sp",Supplier.class).getResultList();
		   return data;
	   }
	 public boolean addSupplier(Supplier sp) {
		 EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrsonemany0319");
		 EntityManager mgr=factory.createEntityManager();
		 
		 mgr.getTransaction().begin();
		 try {
		    mgr.persist(sp);
		    mgr.getTransaction().commit();
		    return true;
		 }catch(Exception ex) {			 
			 mgr.getTransaction().rollback();
			 ex.printStackTrace();
		 }
		 return false;
	 }
}
