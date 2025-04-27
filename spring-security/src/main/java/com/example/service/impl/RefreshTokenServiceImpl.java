package com.example.service.impl;

import com.example.jwt.AuthResponse;
import com.example.jwt.JwtService;
import com.example.jwt.RefreshTokenRequest;
import com.example.models.RefreshToken;
import com.example.models.User;
import com.example.reposiitory.RefreshTokenRepository;
import com.example.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtService jwtService;

    public boolean isRefreshTokenValid(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        Optional<RefreshToken> byToken = refreshTokenRepository.findByToken(refreshTokenRequest.getRefreshToken());
        if (byToken.isEmpty()) {
            System.out.println("Refresh token not valid" + refreshTokenRequest.getRefreshToken());
        }

        RefreshToken refreshToken = byToken.get();

        if (!isRefreshTokenValid(refreshToken.getExpireDate())){
            System.out.println("Refresh token expired" + refreshTokenRequest.getRefreshToken());
        }

        String token = jwtService.generateToken(refreshToken.getUser());
        RefreshToken newRefreshToken = createRefreshToken(refreshToken.getUser());
        RefreshToken savedRefreshToken = refreshTokenRepository.save(newRefreshToken);

        return new AuthResponse(token, savedRefreshToken.getToken());
    }
}
