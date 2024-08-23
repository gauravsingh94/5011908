package com.gaurav.project.online_bookstore.mapper;

import com.gaurav.project.online_bookstore.dto.CustomerDTO;
import com.gaurav.project.online_bookstore.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
