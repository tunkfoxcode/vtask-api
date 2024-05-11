package com.example.vtaskapi.service.impl;

import com.example.vtaskapi.dto.BoardDTO;
import com.example.vtaskapi.entity.Board;
import com.example.vtaskapi.payload.req.CreateBoardReq;
import com.example.vtaskapi.repository.BoardRepository;
import com.example.vtaskapi.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
  private final BoardRepository boardRepository;
  @Override
  public Page<BoardDTO> getAllStarredBoard(Pageable pageable) {
    return boardRepository.findAllByStarred((short)1, pageable).map(board -> {
      var dto = new BoardDTO();
      dto.setId(board.getId());
      dto.setStarred(board.getStarred());
      dto.setBackground(board.getBackground());
      dto.setBoardName(board.getBoardName());
      return dto;
    });
  }

  @Override
  public void createNewBoard(CreateBoardReq req) {
    var board = new Board();
    board.setBoardName(req.getBoardName());
    board.setBackground(req.getBackground());
    board.setWorkspaceId(req.getWorkspaceId());
    boardRepository.save(board);
  }
}
