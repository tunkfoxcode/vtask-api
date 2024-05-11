package com.example.vtaskapi.service;

import com.example.vtaskapi.dto.BoardDTO;
import com.example.vtaskapi.payload.req.CreateBoardReq;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
  Page<BoardDTO> getAllStarredBoard(Pageable pageable);
  void createNewBoard(CreateBoardReq req);
}
