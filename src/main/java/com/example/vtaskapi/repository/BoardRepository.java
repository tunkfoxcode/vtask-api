package com.example.vtaskapi.repository;

import com.example.vtaskapi.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
  Page<Board> findAllByWorkspaceId(Long workspaceId, Pageable pageable);

  Page<Board> findAllByStarred(Short starred, Pageable pageable);
}
