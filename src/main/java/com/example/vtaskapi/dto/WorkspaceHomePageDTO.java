package com.example.vtaskapi.dto;

import com.example.vtaskapi.entity.Board;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceHomePageDTO {
  private Long workspaceId;
  private String workspaceName;
  private List<BoardDTO>boards;
}
