package com.example.vtaskapi.service.impl;

import com.example.vtaskapi.dto.BoardDTO;
import com.example.vtaskapi.dto.WorkspaceHomePageDTO;
import com.example.vtaskapi.entity.Workspace;
import com.example.vtaskapi.payload.req.CreateWorkspaceReq;
import com.example.vtaskapi.repository.BoardRepository;
import com.example.vtaskapi.repository.WorkspaceRepository;
import com.example.vtaskapi.service.WorkspaceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {

  private final WorkspaceRepository workspaceRepository;
  private final BoardRepository boardRepository;

  @Override
  public List<WorkspaceHomePageDTO> getWorkspacesForHomePage() {
    return workspaceRepository.findAll().stream()
        .map(workspace -> {
          var dto = new WorkspaceHomePageDTO();
          dto.setWorkspaceId(workspace.getId());
          dto.setWorkspaceName(workspace.getWorkspaceName());
          //Get boards
          dto.setBoards(
              boardRepository.
                  findAllByWorkspaceId(workspace.getId(), PageRequest.of(0, 10))
                  .map(board -> {
                    var boardDTO = new BoardDTO();
                    boardDTO.setBoardName(board.getBoardName());
                    boardDTO.setBackground(boardDTO.getBackground());
                    boardDTO.setId(board.getId());
                    return boardDTO;
                  }).toList()
          );
          return dto;
        }).toList();
  }

  @Override
  public void createNewWorkspace(CreateWorkspaceReq req) {
    var workspace = new Workspace();
    workspace.setWorkspaceName(req.getWorkspaceName());
    workspaceRepository.save(workspace);
  }
}
