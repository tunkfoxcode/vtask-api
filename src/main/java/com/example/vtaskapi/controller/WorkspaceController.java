package com.example.vtaskapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/workspaces")
@CrossOrigin(value = "*")
public class WorkspaceController {

  @GetMapping
  public ResponseEntity<String> index(){
    return ResponseEntity.ok("Hello workspace");
  }
}
