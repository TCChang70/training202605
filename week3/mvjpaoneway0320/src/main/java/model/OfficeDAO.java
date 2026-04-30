package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OfficeDAO {
   public List<Office> getAllOffices(){
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvjpaoneway0320");
	   EntityManager mgr=factory.createEntityManager();
	   List<Office> data=mgr.createQuery("select c from Office c",Office.class).getResultList();
	   return data;
   }
}
