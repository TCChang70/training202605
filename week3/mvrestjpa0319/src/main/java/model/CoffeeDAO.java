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
}
