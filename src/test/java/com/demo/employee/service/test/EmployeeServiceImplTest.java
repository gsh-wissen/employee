package com.demo.employee.service.test;

import com.demo.employee.entity.Employee;
import com.demo.employee.exception.ResourceNotFoundException;
import com.demo.employee.repository.EmployeeRepository;
import com.demo.employee.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    ObjectMapper om = new ObjectMapper();

    private Employee employee;
    List<Employee> employeeList;

    @Autowired
    EmployeeServiceImpl employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @Before
    public void init(){
        employee = new Employee();
        employee.setFirstName("girish");
        employee.setLastName("shankar");
        employee.setEmailId("girish.shanakr@gmail.com");
        employeeList = Arrays.asList(employee);
    }

    @Test
    public void findAllEmployeesTest(){
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> list = employeeService.findAllEmployees();
        Assert.assertNotNull(list);
    }

    @Test
    public void findEmployeeByIdTest() throws ResourceNotFoundException {
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
        when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(employee));
        ResponseEntity<Employee> response = employeeService.findEmployeeById(Long.valueOf(1));
        Assert.assertNotNull(response);
    }
    @Test
    public void createEmployeeTest(){
        when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        Employee emp = employeeService.createEmployee(employee);
        Assert.assertNotNull(emp);
    }

    @Test
    public void updateEmployeeTest() throws ResourceNotFoundException {
        this.employee.setId(1L);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
        when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(employee));
        when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        ResponseEntity<Employee> response = employeeService.updateEmployee(1L, employee);
        Assert.assertNotNull(response);
    }

    @Test
    public void deleteEmployee() throws ResourceNotFoundException {
        Map<String, Boolean> responseMap = new HashMap<>();
        responseMap.put("deleted", Boolean.TRUE);
        this.employee.setId(1L);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
        when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(employee));

        Map<String, Boolean> response = employeeService.deleteEmployee(1L);
        Assert.assertNotNull(response);
    }


}
