package com.gaurav.project.online_bookstore.controller;

import com.gaurav.project.online_bookstore.dto.CustomerDTO;
import com.gaurav.project.online_bookstore.model.Customer;
import com.gaurav.project.online_bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomer = customerService.saveCustomer(customerDTO);
        savedCustomer.add(linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        customerDTO.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel());
        customerDTO.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers"));
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        customers.forEach(customer ->
            customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel())
        );
        return customers;
    }
}