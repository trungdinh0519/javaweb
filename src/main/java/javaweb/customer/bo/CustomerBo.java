package javaweb.customer.bo;

import java.util.List;

import javaweb.customer.model.Customer;

public interface CustomerBo {
	
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
}
