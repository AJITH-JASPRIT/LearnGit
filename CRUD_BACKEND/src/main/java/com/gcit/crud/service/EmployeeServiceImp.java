package com.gcit.crud.service;

import com.gcit.crud.DTO.EmployeeDTO;
import com.gcit.crud.exception.ResourceNotFoundException;
import com.gcit.crud.model.Employee;
import com.gcit.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gcit.crud.DTO.EmployeeToDTOConvertor.EmployeeToEmployeeDTOConvertor;
import static com.gcit.crud.DTO.EmployeeToDTOConvertor.employeeListToEmployeeDtoListConvertor;


@Service
public class EmployeeServiceImp implements EmployeeService
{
    //Service implementation
    /*
    Service implementation is used to implement the methods which are declared in Service Interface and also
    handles the HTTP methods which are comes from the controller
     */

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<EmployeeDTO> getAllEmployees()
    {
        List<Employee> employeeList=employeeRepository.findAll();
        return employeeListToEmployeeDtoListConvertor(employeeList);
    }

    public EmployeeDTO createEmployee(Employee employee)
    {
        Employee employeeOne = employeeRepository.save(employee);
        return EmployeeToEmployeeDTOConvertor(employeeOne);

    }

    public ResponseEntity<EmployeeDTO> getEmployeeById(long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee not exit with id:"+id));
       EmployeeDTO employeeDTO = EmployeeToEmployeeDTOConvertor(employee);
        return ResponseEntity.ok(employeeDTO);
    }

    public  ResponseEntity<EmployeeDTO> updateEmployee (long id,Employee employeeDetails )
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee not exit with id:"+id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee UpdatedEmployee = employeeRepository.save(employee);


        return ResponseEntity.ok(EmployeeToEmployeeDTOConvertor(UpdatedEmployee));

    }

    public ResponseEntity<Map<String,Boolean>> deleteEmployee(long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee not exit with id:"+id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted Successfully",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
