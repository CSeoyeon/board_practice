package com.example.board_practice.web.repository;

import com.example.board_practice.web.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class BoardRepositoryImplTest {

    BoardRepository boardRepository = new BoardRepositoryImpl();
    @Test
    void save(){
        LocalDate date = LocalDate.now();
        Board board = new Board("df", "dff", date);
        boardRepository.save(board);

        String content = boardRepository.findAll().get(0).getContent();
        Assertions.assertThat(content).isEqualTo("dff");
    }

}