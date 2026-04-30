package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CoffeeDAO{

	private static final Logger logger = Logger.getLogger(CoffeeDAO.class.getName());

	private final static SessionFactory sessionFactory = getSessionFactory();

	protected static SessionFactory getSessionFactory() {
		try {
			return  new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error Open Config:"+e.getMessage());
			return null;
		}
	}

	public void persist(Coffee transientInstance) {
		logger.log(Level.INFO, "persisting Coffees instance");
		Session  ss=  sessionFactory.openSession();
		try {
			Transaction tx=ss.beginTransaction();
			ss.persist(transientInstance);
			tx.commit();
			logger.log(Level.INFO, "persist successful");
		} catch (Exception re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}

	public void delete(String name) {
		logger.log(Level.INFO, "deleting Coffees instance");
		Session  ss=  sessionFactory.openSession();
		try {
			//sessionFactory.getCurrentSession().delete(persistentInstance);
			Transaction tx=ss.beginTransaction();
			Coffee instance = (Coffee) ss.find(model.Coffee.class, name);			
			if(instance!=null) {
			   ss.delete(instance);
			}else {
				throw new RuntimeException("delete error");
			}
			tx.commit();
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}

	public Coffee merge(String name,Coffee detachedInstance) {
		logger.log(Level.INFO, "merging Coffees instance");
		Session  ss=  sessionFactory.openSession();
		try {
			//Coffees result = (Coffees) sessionFactory.getCurrentSession().merge(detachedInstance);			
			Transaction tx=ss.beginTransaction();
			Coffee instance = (Coffee) ss.find(model.Coffee.class, name);
			Coffee result=null;
			if(instance!=null) {
			   result= (Coffee)ss.merge(detachedInstance);
			}else {
				throw new RuntimeException("update error");
			}
			tx.commit();
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed "+re);
			throw re;
		}finally {
			ss.close();
		}
		
	}

	public Coffee findById(String cofName) {
		logger.log(Level.INFO, "findById getting Coffees instance with id: " + cofName);
		Session  ss=  sessionFactory.openSession();
		try {	
			Transaction tx=ss.beginTransaction();
			Coffee instance = (Coffee) ss.find(model.Coffee.class, cofName);
			tx.commit();
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (Exception re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}
	
	public List<Coffee> getAllCoffees(){
		logger.log(Level.INFO, "get all coffees" );
		Session  ss=  sessionFactory.openSession();
		try {	
			//Transaction tx=ss.beginTransaction();
			List<Coffee> instance = ss.createQuery("from Coffee").list();
			//tx.commit();
			if (instance == null) {
				logger.log(Level.INFO, "get all successful, no instance found");
			} else {
				logger.log(Level.INFO, "get all successful, instance found");
			}
			return instance;
		} catch (Exception re) {
			logger.log(Level.SEVERE, "get all failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}
	
}

 

