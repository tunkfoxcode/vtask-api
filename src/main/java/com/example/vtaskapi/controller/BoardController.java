package com.example.vtaskapi.controller;

import com.example.vtaskapi.dto.BoardDTO;
import com.example.vtaskapi.payload.req.CreateBoardReq;
import com.example.vtaskapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/boards")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;

  @GetMapping(value = "starred")
  public ResponseEntity<Page<BoardDTO>> getAllStarredBoards(
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size
  ){
    return ResponseEntity.ok(boardService.getAllStarredBoard(PageRequest.of(page, size)));
  }

  @PostMapping
  public ResponseEntity<Void> createNewBoard(
      @RequestBody CreateBoardReq req
  ){
    boardService.createNewBoard(req);
    return ResponseEntity.noContent().build();
  }
}
