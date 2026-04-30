package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.util.logging.Level;

public class EmployeeDAO {
	private final static SessionFactory sessionFactory = getSessionFactory();

	protected static SessionFactory getSessionFactory() {
		try {
			return  new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error Open Config:"+e.getMessage());
			return null;
		}
	}
	
	public List<Employee> getAllEmployees(){
		Session ss=sessionFactory.openSession();
		return ss.createQuery("from Employee").list();
	}
	
	public void persist(Employee transientInstance) {		
		Session  ss=  sessionFactory.openSession();
		try {
			Transaction tx=ss.beginTransaction();
			ss.persist(transientInstance);
			tx.commit();
			
		} catch (Exception re) {
			System.out.println("persist failed"+re.getMessage());
			throw re;
		}finally {
			ss.close();
		}
	}
	public Employee merge(int  id,Employee detachedInstance) {		
		Session  ss=  sessionFactory.openSession();
		try {						
			Transaction tx=ss.beginTransaction();
			Employee instance = (Employee) ss.find(Employee.class, id);
			Employee result=null;
			if(instance!=null) {
			   result= (Employee)ss.merge(detachedInstance);
			}else {
				throw new RuntimeException("update error");
			}
			tx.commit();
			
			return result;
		} catch (RuntimeException re) {
			System.out.println("merge failed "+re.getMessage());
			throw re;
		}finally {
			ss.close();
		}		
	}
	public void delete(int id) {		
		Session  ss=  sessionFactory.openSession();
		try {			
			Transaction tx=ss.beginTransaction();
			Employee instance = (Employee) ss.find(Employee.class, id);			
			if(instance!=null) {
			   ss.delete(instance);
			}else {
				throw new RuntimeException("delete error");
			}
			tx.commit();			
		} catch (RuntimeException re) {
			System.out.println("delete failed"+re.getMessage());
			throw re;
		}finally {
			ss.close();
		}
	}
}
