package com.ajna.service;


import com.ajna.dao.CustomerDAO;
import com.ajna.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
