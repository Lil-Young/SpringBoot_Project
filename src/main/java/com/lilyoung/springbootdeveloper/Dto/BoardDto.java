package com.lilyoung.springbootdeveloper.Dto;

import com.lilyoung.springbootdeveloper.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = board.getCreateAt();
        this.updatedAt = board.getUpdatedAt();
    }
}
