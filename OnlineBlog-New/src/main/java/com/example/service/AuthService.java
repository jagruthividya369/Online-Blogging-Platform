package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.dto.RegisterRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void signUp(RegisterRequest registerRequest) {
		
		User user=new User();
		user.setUserName(registerRequest.getUserName());
		user.setEmailId(registerRequest.getEmailId());
		user.setPassword(encodePassword(registerRequest.getPassword()));
		
		userRepo.save(user);		
	}
	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
		
	}

}
