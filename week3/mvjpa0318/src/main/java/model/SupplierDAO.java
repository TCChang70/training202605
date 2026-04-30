package model;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SupplierDAO {
    public List<Supplier> getAllSuppliers(){
    	  EntityManagerFactory factory=  Persistence.createEntityManagerFactory("mvjpa0318"); 
    	  EntityManager mgr=factory.createEntityManager();
    	  return mgr.createNamedQuery("Supplier.findAll").getResultList();
    }
}
