package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Repository.BoardRepository;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public Long createBoard(Board board) {
        LocalDateTime now = LocalDateTime.now();
        board.setCreatedDate(now);
        board.setActive(true);
        boardRepository.save(board);
        return board.getBoardId();
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).get();
    }

    public Board activateBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).get();
        board.setActive(true);
        boardRepository.save(board);
        return board;
    }

    public void deActivateBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).get();
        board.setActive(false);
        boardRepository.save(board);
    }

    public void deleteBoard(Long boardId) {
        Board board = boardRepository
                .findById(boardId)
                .get();
        boardRepository.delete(board);
    }
}
