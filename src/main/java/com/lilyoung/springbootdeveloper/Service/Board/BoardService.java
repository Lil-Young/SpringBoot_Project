package com.lilyoung.springbootdeveloper.Service.Board;

import com.lilyoung.springbootdeveloper.Dto.BoardDto;
import com.lilyoung.springbootdeveloper.Entity.Board;
import com.lilyoung.springbootdeveloper.Repository.Board.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(BoardDto request) {
        return boardRepository.save(request.toEntity());
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
    }

    @Transactional
    public Board update(Long id, BoardDto request) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        board.update(request.getTitle(), request.getContent());
        return board;
    }

    public void delete(Long id) {
        if (!boardRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 게시글이 없습니다. id = " + id);
        }
        boardRepository.deleteById(id);
    }
}
