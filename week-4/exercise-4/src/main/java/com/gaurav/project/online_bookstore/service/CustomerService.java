package com.gaurav.project.online_bookstore.service;

import com.gaurav.project.online_bookstore.model.Customer;
import com.gaurav.project.online_bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}