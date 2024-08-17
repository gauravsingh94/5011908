package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    //    create or update the department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    //    get department by id
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    //    get all department
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    //    delete department by id
    public boolean deleteDepartmentById(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
