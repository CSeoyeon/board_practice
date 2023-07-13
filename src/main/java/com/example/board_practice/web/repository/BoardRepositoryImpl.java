package com.example.board_practice.web.repository;

import com.example.board_practice.web.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
    private final static ConcurrentHashMap<Long, Board> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();

    @Override
    public Board save(Board board) {
        board.setId(sequence.incrementAndGet());
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Board findById(Long boardId) {
        return store.get(boardId);
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long boardId, Board board) {
        Board byId = findById(boardId);
        byId.setTitle(board.getTitle());
        byId.setContent(board.getContent());
    }

    @Override
    public void remove(Long boardId) {
        store.remove(boardId);
    }
}
