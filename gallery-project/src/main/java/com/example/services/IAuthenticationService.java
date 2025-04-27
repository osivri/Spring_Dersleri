package com.example.services;

import com.example.dto.AuthRequest;
import com.example.dto.AuthResponse;
import com.example.dto.DtoUser;
import com.example.dto.RefreshTokenRequest;

public interface IAuthenticationService {
    public DtoUser register(AuthRequest authRequest);
    public AuthResponse authenticate(AuthRequest authRequest);
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
