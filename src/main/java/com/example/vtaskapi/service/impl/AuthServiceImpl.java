package com.example.vtaskapi.service.impl;

import com.example.vtaskapi.model.Token;
import com.example.vtaskapi.payload.req.LoginRequest;
import com.example.vtaskapi.payload.res.LoginResponse;
import com.example.vtaskapi.service.AuthService;
import com.example.vtaskapi.storage.TokenStorage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final TokenStorage tokenStorage;

  @Override
  public LoginResponse login(LoginRequest request) {
    if (request.getPassword() == null || request.getUsername() == null) {
      throw new RuntimeException("Username or password is null");
    }
    if (!"username".equals(request.getUsername())) {
      throw new RuntimeException("Username is not match");
    }
    if (!"password".equals(request.getPassword())) {
      throw new RuntimeException("Password is not match");
    }
    Token token = new Token();
    token.setToken(UUID.randomUUID().toString());
    token.setExpiredAt(Instant.now().plus(15, ChronoUnit.MINUTES));
    tokenStorage.storeToken(token);
    var response = new LoginResponse();
    response.setUsername(request.getUsername());
    response.setToken(token.getToken());
    return response;
  }
}
