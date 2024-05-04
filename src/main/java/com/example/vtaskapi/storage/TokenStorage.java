package com.example.vtaskapi.storage;

import com.example.vtaskapi.model.Token;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TokenStorage {
  private List<Token> tokens = new LinkedList<>();

  public void storeToken(Token token){
    tokens.add(token);
  }

  public Token getToken(String token){
    for(Token tk: tokens){
      if(token.equals(tk.getToken())){
        return tk;
      }
    }
    return null;
  }
}
