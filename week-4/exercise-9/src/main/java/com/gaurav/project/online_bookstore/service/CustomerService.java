package com.gaurav.project.online_bookstore.service;

import com.gaurav.project.online_bookstore.dto.CustomerDTO;
import com.gaurav.project.online_bookstore.exception.ResourceNotFoundException;
import com.gaurav.project.online_bookstore.mapper.CustomerMapper;
import com.gaurav.project.online_bookstore.model.Customer;
import com.gaurav.project.online_bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .toList();
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setEmail(customerDTO.getEmail());
        existingCustomer.setPhoneNumber(customerDTO.getPhoneNumber());

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
        customerRepository.deleteById(id);
    }
}