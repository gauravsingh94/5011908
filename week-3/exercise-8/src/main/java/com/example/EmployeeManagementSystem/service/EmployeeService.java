package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //    create and update employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //    get employee by id
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    // Get all employees with pagination and sorting
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    //   Delete employee by id
    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeRepository.findAllProjectedBy();
    }
}
