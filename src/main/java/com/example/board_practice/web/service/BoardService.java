package com.example.board_practice.web.service;

import com.example.board_practice.web.domain.Board;
import com.example.board_practice.web.repository.BoardRepository;
import com.example.board_practice.web.repository.BoardRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> showBoard(){
        return boardRepository.findAll();
    }

    public void addBoard(Board board){
        board.setDate(setDate());
        boardRepository.save(board);
    }

    public Board boardMath(Long id){
        return boardRepository.findById(id);
    }

    public void update(Long id, Board board){
        boardRepository.update(id, board);
    }

    public void remove(Long id){
        boardRepository.remove(id);
    }

    public LocalDate setDate(){
        LocalDate date = LocalDate.now();
        return date;
    }
}
