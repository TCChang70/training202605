package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SupplierDAO {
	public Session build() {
    	try {
    		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	    return factory.openSession();
    	}catch(Exception ex) {    		
    		System.out.println("Hibernate connection error "+ex.getMessage());
    	}
    	return null;
    }
    
    public List<Suppliers> getAllSuppliers(){
    	Session ss=build();
    	if(ss==null) {
    		System.out.println("getAllSuppliers() Hibernate connection error");
    		return new ArrayList<Suppliers>();
    	}
    	return ss.createQuery("from Suppliers",Suppliers.class).list();
    }
    
    public List<Suppliers> getAllUseNative(){
    	Session ss=build();
    	if(ss==null) {
    		System.out.println("getAllSuppliers() Hibernate connection error");
    		return new ArrayList<Suppliers>();
    	}
    	return ss.createNativeQuery("select * from classicmodels.suppliers",Suppliers.class).list();
    }
    
    public Suppliers findById(int id){
    	Session ss=build();
    	if(ss==null) {
    		System.out.println("findById() Hibernate connection error");
    		return null;
    	}
    	Query<Suppliers> qry= ss.createQuery("from Suppliers where supId= ?1",Suppliers.class);
    	qry.setParameter(1, id);
    	return qry.list()!=null && qry.list().size()>0 ? qry.list().get(0):null;
    }
}
