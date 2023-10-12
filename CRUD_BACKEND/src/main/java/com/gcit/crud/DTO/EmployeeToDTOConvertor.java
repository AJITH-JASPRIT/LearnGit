package com.gcit.crud.DTO;

import com.gcit.crud.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeToDTOConvertor
{
    public static EmployeeDTO EmployeeToEmployeeDTOConvertor(Employee employee)
    {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
    }

    public static List<EmployeeDTO>  employeeListToEmployeeDtoListConvertor(List<Employee> employeeList)
    {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = EmployeeToEmployeeDTOConvertor(employee);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;

    }




}
