package model;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class StudentDAO {
   public List<Student>  getAllStudents(){
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   TypedQuery<Student> query= mgr.createQuery("select s from Student s", Student.class);
	   return query.getResultList();
   }
   
   public boolean addStudent(Student s) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
	     mgr.persist(s);
	     mgr.getTransaction().commit();
	   }catch(Exception ex) {
		   System.out.println("add student error "+ex.getMessage());
		   mgr.getTransaction().rollback();
		   return false;
	   }	   
	   return true;
   }
   public boolean updateStudent(int sid,Student st) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   Student found=mgr.find(Student.class, sid);
	   if(found!=null) {
		   found.setAge(st.getAge());
		   found.setSname(st.getSname());
		   mgr.getTransaction().begin();
		   mgr.merge(found);		   
		   mgr.getTransaction().commit();
		   return true;
	   }else {
		   return false; 
	   }
   }
   public Student findById(int sid) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   Student found=mgr.find(Student.class, sid);
	   return found;
   }
   public boolean deleteStudent(int sid) {
	   EntityManagerFactory factory= Persistence.createEntityManagerFactory("mvrestjpa0319");
	   EntityManager mgr=factory.createEntityManager();
	   Student found=mgr.find(Student.class, sid);
	   if(found!=null) {		   
		   mgr.getTransaction().begin();
		   try {
		       mgr.remove(found);		   
		       mgr.getTransaction().commit();
		       return true;
		   }catch(Exception ex) {
			   System.out.println("delete student error "+ex.getMessage());
			   mgr.getTransaction().rollback();
		   }
		   return false;
	   }else {
		   return false; 
	   }
   }
   
}
