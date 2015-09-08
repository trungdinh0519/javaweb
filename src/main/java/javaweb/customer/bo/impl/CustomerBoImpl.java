package javaweb.customer.bo.impl;

import java.util.List;

import javaweb.customer.bo.CustomerBo;
import javaweb.customer.dao.CustomerDao;
import javaweb.customer.model.Customer;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {

        customerDao.addCustomer(customer);

    }

    public List<Customer> findAllCustomer() {

        return customerDao.findAllCustomer();
    }
}
