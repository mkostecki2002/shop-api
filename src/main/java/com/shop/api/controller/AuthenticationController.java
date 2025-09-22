package com.shop.api.controller;

import com.shop.api.dto.AuthenticationResponse;
import com.shop.api.dto.LoginRequest;
import com.shop.api.dto.RegisterRequest;
import com.shop.api.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.login(loginRequest);
        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}
