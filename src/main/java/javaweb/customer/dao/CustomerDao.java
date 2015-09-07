package javaweb.customer.dao;

import java.util.List;

import javaweb.customer.model.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
}
