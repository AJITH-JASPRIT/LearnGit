package com.jwt.demo.service;

import com.jwt.demo.common.APIResponse;
import com.jwt.demo.dto.LoginRequestDTO;
import com.jwt.demo.dto.SignUpRequestDTO;
import com.jwt.demo.entity.User;
import com.jwt.demo.repository.UserRepository;
import com.jwt.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{

    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        APIResponse ApiResponse = new APIResponse();
        //Validation


        // dto to entity
        User userEntity = new User();
        userEntity.setName(signUpRequestDTO.getName());
        userEntity.setEmailId(signUpRequestDTO.getEmailId());
        userEntity.setActive(Boolean.TRUE);
        userEntity.setGender(signUpRequestDTO.getGender());
        userEntity.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
        userEntity.setPassword(signUpRequestDTO.getPassword());

        //store to database
        userEntity = userRepository.save(userEntity);

        //return
        String jwtToken = jwtUtils.generateJwt(userEntity);
        ApiResponse.setData(jwtToken);
        return ApiResponse;
    }

    public APIResponse login(LoginRequestDTO loginRequestDTO)
    {
        APIResponse ApiResponse = new APIResponse();

        //Validation

        //Verify user exit with given mail id and password
         User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword
                 (loginRequestDTO.getEmailId(),loginRequestDTO.getPassword());
        //Response
        if(user == null)
        {
            ApiResponse.setData("User not exists");
            return ApiResponse;
        }
        String jwtToken = jwtUtils.generateJwt(user);
        ApiResponse.setData(jwtToken);
        return ApiResponse;

    }
}
