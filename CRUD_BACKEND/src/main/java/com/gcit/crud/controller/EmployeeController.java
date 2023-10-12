package com.gcit.crud.controller;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;

import com.gcit.crud.DTO.EmployeeDTO;
import com.gcit.crud.model.Employee;
import com.gcit.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

    //Controller
    /*
      Controller is used to navigate the incoming HTTP methods to respected methods in the
      service implementation
     */

    @Autowired
    EmployeeService employeeService;

    //get all employees
    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    //create employee
    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }


    //get Single employee (get emp by id)
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long id)
    {
        return employeeService.getEmployeeById(id);
    }

    //to update employee
    @PutMapping("/employees/{id}")
    public  ResponseEntity<EmployeeDTO> updateEmployee (@PathVariable long id,@RequestBody Employee employeeDetails )
    {
        return employeeService.updateEmployee(id,employeeDetails);
    }

    //To delete Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id)
    {
        return employeeService.deleteEmployee(id);
    }


}

