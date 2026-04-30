package model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class SupplierDAO {
	private final static SessionFactory sessionFactory = getSessionFactory();

	static SessionFactory getSessionFactory() {
		try {
			return  new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error Open Config:"+e.getMessage());
			return null;
		}
	}
	
	public List<Suppliers> getAllSuppliers(){
		Session ss=sessionFactory.openSession();
		List<Suppliers> list=ss.createQuery("from Suppliers",Suppliers.class).list();
		return list;
	}

}
