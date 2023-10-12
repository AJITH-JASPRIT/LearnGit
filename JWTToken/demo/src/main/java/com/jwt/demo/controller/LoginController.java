package com.jwt.demo.controller;

import com.jwt.demo.common.APIResponse;
import com.jwt.demo.config.JWTInterceptor;
import com.jwt.demo.dto.LoginRequestDTO;
import com.jwt.demo.dto.RequestMeta;
import com.jwt.demo.dto.SignUpRequestDTO;
import com.jwt.demo.service.LoginService;
import com.jwt.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/")
public class LoginController
{

    @Autowired
    LoginService loginService ;
    @Autowired
    JwtUtils jwtUtils;
    //    @Autowired
//    RequestMeta requestMeta;

    @PostMapping("/signUp")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO)
    {
        APIResponse ApiResponse = loginService.signUp(signUpRequestDTO);
        System.out.println("::::::::inside sign up controller");

        return ResponseEntity.status(ApiResponse.getStatus()).body(ApiResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        APIResponse ApiResponse = loginService.login(loginRequestDTO);

        return ResponseEntity.status(ApiResponse.getStatus()).body(ApiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse> privateApi(@RequestHeader(value = "authorization" , defaultValue = "") String auth) throws Exception
    {
      jwtUtils.verify(auth);
      APIResponse apiResponse = new APIResponse();
      apiResponse.setData("ok");
      //To check requestMeta working
//        System.out.println(requestMeta.getUserName());
      return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
