package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class CoffeesDAO {
    public Session build() {
    	try {
    		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	    return factory.openSession();
    	}catch(Exception ex) {    		
    		System.out.println("Hibernate connection error "+ex.getMessage());
    	}
    	return null;
    }
    
    public List<Coffees> getAllCoffees(){
    	Session ss=build();
    	if(ss==null) {
    		System.out.println("getAllCoffees() Hibernate connection error");
    		return new ArrayList<Coffees>();
    	}
    	return ss.createQuery("from Coffees").list();
    }
}
