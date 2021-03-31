package com.example.demo.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.DTO.UserRegistrationDto;
import com.example.demo.Model.User;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
}
