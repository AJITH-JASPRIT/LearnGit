package com.jwt.demo.exception;

public class AccessDeniedException extends RuntimeException
{
   public AccessDeniedException(String msg)
    {
        super(msg);
    }

}
