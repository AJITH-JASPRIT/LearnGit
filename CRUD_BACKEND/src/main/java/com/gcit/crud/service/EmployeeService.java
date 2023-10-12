package com.gcit.crud.service;
import com.gcit.crud.DTO.EmployeeDTO;
import com.gcit.crud.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface EmployeeService
{
    //Service interface
    /*
    in service interface we just declares the methods which are
    used to implements the incoming HTTP methods from controller in Service implementation
     */

    //TO get all employees
    public List<EmployeeDTO> getAllEmployees();

    //To create Employee
    public EmployeeDTO createEmployee(Employee employee);

    //To get single employee by ID
    public ResponseEntity<EmployeeDTO> getEmployeeById(long id);

    //To update employee
    public  ResponseEntity<EmployeeDTO> updateEmployee (long id,Employee employeeDetails );

    //To Delete employee
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(long id);


}
