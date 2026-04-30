package model;

import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
    private List<Customer> customerList = new ArrayList<>();
    private static CustomerDAO ourInstance = new CustomerDAO();
    public static CustomerDAO getInstance() {
        return ourInstance;
    }
    public String addCustomer(String name,String address,String phone) {
    	   Customer c=new Customer();
    	   c.setName(name);
    	   c.setAddress(address);
    	   c.setPhoneNumber(phone);
    	   return this.addCustomer(c);
    }
    public String addCustomer(Customer customer) {
    	int index=0;
    	String newId="1";
    	if(customerList.size()>0) {
    	  index=customerList.size()-1;
      newId = Integer.parseInt(customerList.get(index).getId())+1+"";
    	}
        customer.setId(newId);
        customerList.add(customer);
        System.out.println("Post Customer:"+customer);
        return newId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    public Customer getCustomerById(String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }
}

