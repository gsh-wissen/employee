package com.demo.employee.service;

import com.demo.employee.entity.Employee;
import com.demo.employee.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    ResponseEntity<Employee> findEmployeeById(Long employeeId) throws ResourceNotFoundException;
    Employee createEmployee(Employee employee);
    ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
