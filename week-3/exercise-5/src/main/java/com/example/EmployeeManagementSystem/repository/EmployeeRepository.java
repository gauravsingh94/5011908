package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name == :name")
    List<Employee> findEmployeeByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name==:departmentName")
    List<Employee> findEmployeeByDepartmentName(@Param("departmentName") String departmentName);
}
