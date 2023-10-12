package com.jwt.demo.dto;

import lombok.Data;

@Data
public class LoginRequestDTO
{
    private String emailId;
    private String password;
}
