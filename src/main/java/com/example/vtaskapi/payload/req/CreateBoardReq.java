package com.example.vtaskapi.payload.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CreateBoardReq {
  String boardName;
  String background;
  Long workspaceId;
}
