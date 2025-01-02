package com.lilyoung.springbootdeveloper.Controller;

import com.lilyoung.springbootdeveloper.Dto.BoardDto;
import com.lilyoung.springbootdeveloper.Entity.Board;
import com.lilyoung.springbootdeveloper.Service.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardViewController {
    private final BoardService boardService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<BoardDto> board = boardService.findAll().stream()
                .map(BoardDto::new)
                .toList();
        model.addAttribute("board", board);
        return "boardList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", new BoardDto(board));

        return "board";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        System.out.println("new-article ::: id : " + id );
        if (id == null) {
            model.addAttribute("board", new BoardDto());
        } else {
            Board board = boardService.findById(id);
            model.addAttribute("board", new BoardDto(board));
        }
        return "newArticle";
    }
}
