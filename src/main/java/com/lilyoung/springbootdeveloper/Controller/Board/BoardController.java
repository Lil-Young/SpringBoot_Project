package com.lilyoung.springbootdeveloper.Controller.Board;

import com.lilyoung.springbootdeveloper.Dto.BoardDto;
import com.lilyoung.springbootdeveloper.Entity.Board;
import com.lilyoung.springbootdeveloper.Service.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/articles")
    public ResponseEntity<Board> addArticle(@RequestBody BoardDto request) {
        Board saveArticle = boardService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<BoardDto>> findAllArticles() {
        List<BoardDto> articles = boardService.findAll()
                .stream()
                .map(BoardDto::new)
                .toList();
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Board> findArticle(@PathVariable Long id) {
        Board board = boardService.findById(id);
        return ResponseEntity.ok().body(board);
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Board> updateArticle(@PathVariable Long id, @RequestBody BoardDto request) {
        Board updateArticle = boardService.update(id, request);
        return ResponseEntity.ok(updateArticle);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id){
        boardService.delete(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다. id = " + id);
    }
}
