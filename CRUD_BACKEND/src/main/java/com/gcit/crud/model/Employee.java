package com.gcit.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

/*
     Model
     -----
     Firstly we have to create a model(nothing but a object) that which is going to connect with database
     then we have to specify that this class is a @Entity class to use the entity annotation to connect with DB

 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String emailId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

}
