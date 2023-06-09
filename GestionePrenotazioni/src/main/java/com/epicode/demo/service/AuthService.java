package com.epicode.demo.service;

import com.epicode.demo.payload.LoginDto;
import com.epicode.demo.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}