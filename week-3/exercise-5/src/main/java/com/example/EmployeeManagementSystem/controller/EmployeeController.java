package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Savepoint;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    //    create or update employee
    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //    get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        if (employeeService.deleteEmployeeById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
