package com.example.board_practice.web.repository;

import com.example.board_practice.web.domain.Board;

import java.util.List;

public interface BoardRepository {
    //crud

    Board save(Board board);
    Board findById(Long boardId);
    List<Board> findAll();
    void update(Long boardId, Board board);
    void remove(Long boardId);

}
