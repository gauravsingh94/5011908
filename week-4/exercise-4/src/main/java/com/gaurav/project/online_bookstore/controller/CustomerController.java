package com.gaurav.project.online_bookstore.controller;

import com.gaurav.project.online_bookstore.model.Customer;
import com.gaurav.project.online_bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Customer> createCustomerJson(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Customer> createCustomerForm(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }
}
