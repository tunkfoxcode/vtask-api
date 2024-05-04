package com.example.vtaskapi.controller;

import com.example.vtaskapi.payload.req.LoginRequest;
import com.example.vtaskapi.payload.res.LoginResponse;
import com.example.vtaskapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/auth")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class AuthController {
  private final AuthService authService;

  @PostMapping(value = "/login")
  public ResponseEntity<LoginResponse> login(
      @RequestBody LoginRequest request
  ){
    return ResponseEntity.ok(authService.login(request));
  }
}
