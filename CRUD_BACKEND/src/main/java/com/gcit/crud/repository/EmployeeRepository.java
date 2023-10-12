package com.gcit.crud.repository;

import com.gcit.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    /*
    Repository
    ----------
    Repository is the giver of the methods which are used to communicate with the database
    for that we have to extend a Jpa repo and we have to inject the entity object and id into jpa repo
     */
}
