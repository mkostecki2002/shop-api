package com.shop.api.service;

import com.shop.api.dto.AuthenticationResponse;
import com.shop.api.dto.LoginRequest;
import com.shop.api.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AuthenticationResponse login(LoginRequest loginRequest) throws AuthenticationException {
        if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new RuntimeException("Email or password is incorrect");
        };
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Authentication: " + authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }
}
