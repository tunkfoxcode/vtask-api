package com.example.vtaskapi.service;

import com.example.vtaskapi.dto.WorkspaceHomePageDTO;
import com.example.vtaskapi.payload.req.CreateWorkspaceReq;
import java.util.List;

public interface WorkspaceService {
  List<WorkspaceHomePageDTO> getWorkspacesForHomePage();

  void createNewWorkspace(CreateWorkspaceReq req);
}
