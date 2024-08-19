package com.gaurav.project.online_bookstore.repository;

import com.gaurav.project.online_bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
