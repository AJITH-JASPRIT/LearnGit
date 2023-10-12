package com.jwt.demo.entity;

import com.jwt.demo.common.Constant;
import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@Entity
@Table(name = "User_details")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "userType")
    private String userType = Constant.USER_TYPE.NORMAL;
    @Column(name = "password")
    private String password;
    @Column(name = "isActive")
    private boolean isActive = true;
    @Column(name = "loginCount")
    private Integer loginCount = 0;
    @Column(name = "ssoType")
    private String ssoType;
    @Column(name = "loginAt")
    private DateTime loginAt;
    @Column(name = "createdAt")
    private DateTime createdAt;
    @Column(name = "updatedAt")
    private DateTime updatedAt;

    @PrePersist
    public void onSave()
    {
        DateTime currentTime = new DateTime();
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }
    @PostPersist
    public void onUpdate()
    {
        this.updatedAt = new DateTime();
    }




}
