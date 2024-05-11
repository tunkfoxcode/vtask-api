package com.example.vtaskapi.controller;

import com.example.vtaskapi.dto.WorkspaceHomePageDTO;
import com.example.vtaskapi.payload.req.CreateWorkspaceReq;
import com.example.vtaskapi.service.WorkspaceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/workspaces")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class WorkspaceController {
  private final WorkspaceService workspaceService;
  @PostMapping
  public ResponseEntity<Void> createWorkspace(
      @RequestBody CreateWorkspaceReq req
  ){
    workspaceService.createNewWorkspace(req);
    return ResponseEntity.noContent().build();
  }

  @GetMapping(value = "/home-page")
  public ResponseEntity<List<WorkspaceHomePageDTO>> getAllWorkspaceForHomePage(){
    return ResponseEntity.ok(workspaceService.getWorkspacesForHomePage());
  }
}
