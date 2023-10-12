package com.gcit.crud.DTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeDTO
{
    /*
    DTO is nothing but a exact xerox of the original entity,and entity to dto convertor is
    used to convert the original entity to dto object,when we want to return a response a entities,while that we will
    return the dto object instead of original entity because of some safety reasons
     */
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

    public EmployeeDTO(long id,String firstName, String lastName, String emailId) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}
