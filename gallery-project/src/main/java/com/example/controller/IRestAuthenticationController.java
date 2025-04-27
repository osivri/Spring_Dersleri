package com.example.controller;


import com.example.dto.AuthRequest;
import com.example.dto.AuthResponse;
import com.example.dto.DtoUser;
import com.example.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);
    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
    public RootEntity<AuthResponse> refresh(RefreshTokenRequest refreshTokenRequest);
}
