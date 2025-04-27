package com.example.service;

import com.example.dto.DtoUser;
import com.example.jwt.AuthRequest;
import com.example.jwt.AuthResponse;

public interface IAuthService {
    public DtoUser register(AuthRequest authRequest);
    public AuthResponse authenticate(AuthRequest authRequest);
}
