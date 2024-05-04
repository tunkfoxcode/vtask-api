package com.example.vtaskapi.filter;

import com.example.vtaskapi.model.Token;
import com.example.vtaskapi.storage.TokenStorage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenFilter extends OncePerRequestFilter {
  private final TokenStorage tokenStorage;

  public TokenFilter(TokenStorage tokenStorage) {
    this.tokenStorage = tokenStorage;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String tokenString = request.getHeader("Authorization");

    if(Objects.isNull(tokenString)){
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    Token token = tokenStorage.getToken(tokenString);
    if(token == null || token.getExpiredAt().isBefore(Instant.now())){
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    SecurityContextHolder.getContext().setAuthentication(
        new Authentication() {
          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
          }

          @Override
          public Object getCredentials() {
            return null;
          }

          @Override
          public Object getDetails() {
            return null;
          }

          @Override
          public Object getPrincipal() {
            return tokenString;
          }

          @Override
          public boolean isAuthenticated() {
            return true;
          }

          @Override
          public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

          }

          @Override
          public String getName() {
            return null;
          }
        }
    );
    filterChain.doFilter(request, response);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return request.getServletPath().contains("auth");
  }
}
