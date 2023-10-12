package com.jwt.demo.dto;

import lombok.Data;

@Data
public class RequestMeta
{
    private Long userId;
    private String userName;
    private String emailId;
    private String userType;
}
