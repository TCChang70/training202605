package model;
import java.util.*;
import javax.persistence.*;

public class EmployeeDAO {
   public List<Employee> getAllEmployees(){
	   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrsjpa0331");
	   EntityManager mgr=factory.createEntityManager();
	   TypedQuery<Employee> query=mgr.createNamedQuery("Employee.findAll", Employee.class);
	   return query.getResultList();
   }
   
   public Employee findById(int no) {
	   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrsjpa0331");
	   EntityManager mgr=factory.createEntityManager();
	   Employee found=mgr.find(Employee.class, no);
	   return found;
   }
   
   public boolean addEmployee(Employee emp) {
	   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrsjpa0331");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		   mgr.persist(emp);
		   mgr.getTransaction().commit();
		   return true;
	   }catch(Exception ex) {
		   System.out.println("add employee error "+ex.getMessage());
		   mgr.getTransaction().rollback();
	   }
	   return false;
   }
   public boolean deleteEmployee(int  empId) {
	   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrsjpa0331");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		   Employee emp=mgr.find(Employee.class, empId);
		   if(emp==null)return false;
		   mgr.remove(emp);
		   mgr.getTransaction().commit();
		   return true;
	   }catch(Exception ex) {
		   System.out.println("delete employee error "+ex.getMessage());
		   mgr.getTransaction().rollback();
	   }
	   return false;
   }
   public Employee updateEmployee(int empId,Employee emp) {
	   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrsjpa0331");
	   EntityManager mgr=factory.createEntityManager();
	   mgr.getTransaction().begin();
	   try {
		   Employee found=mgr.find(Employee.class, empId);
		   if(found==null)return null;
		   found.setEmail(emp.getEmail());
		   found.setExtension(emp.getExtension());
		   found.setFirstName(emp.getFirstName());
		   found.setLastName(emp.getLastName());
		   found.setJobTitle(emp.getJobTitle());
		   found.setOfficeCode(emp.getOfficeCode());
		   found.setReportsTo(emp.getReportsTo());
		   mgr.merge(found);
		   mgr.getTransaction().commit();
		   return found;
	   }catch(Exception ex) {
		   System.out.println("update employee error "+ex.getMessage());
		   mgr.getTransaction().rollback();
	   }
	   return null;
   }
}
