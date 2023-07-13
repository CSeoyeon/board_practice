package com.example.board_practice.web.controller;

import com.example.board_practice.web.domain.Board;
import com.example.board_practice.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/")
    public String boardList(Model model){
        List<Board> boards = boardService.showBoard();
        model.addAttribute("boards", boards);
        return "board/postList";
    }

    @GetMapping("/addBoard")
    public String addBoardForm(){
        return"board/addPost";
    }

    @PostMapping("/addBoard")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes){
        boardService.addBoard(board);
        redirectAttributes.addAttribute("boardId", board.getId());
        redirectAttributes.addFlashAttribute("status", true);
        return "redirect:/{boardId}";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable Long boardId, Model model){
        Board item = boardService.boardMath(boardId);
        model.addAttribute("item", item);
        return "board/post";
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model){
        Board board = boardService.boardMath(boardId);
        model.addAttribute("board", board);
        return "board/editPost";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoard(@PathVariable Long boardId,
                            @ModelAttribute Board board,
                            RedirectAttributes redirectAttributes){
        boardService.update(boardId, board);
        redirectAttributes.addAttribute("boardId", board.getId());
        redirectAttributes.addFlashAttribute("status", true);
        return "redirect:/{boardId}";
    }

    @GetMapping("/{boardId}/delete")
    public String removeBoard(@PathVariable Long boardId){
        boardService.remove(boardId);
        return "/board/postList";
    }

}
