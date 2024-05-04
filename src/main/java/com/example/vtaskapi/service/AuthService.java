package com.example.vtaskapi.service;

import com.example.vtaskapi.payload.req.LoginRequest;
import com.example.vtaskapi.payload.res.LoginResponse;

public interface AuthService {
  LoginResponse login(LoginRequest request);
}
