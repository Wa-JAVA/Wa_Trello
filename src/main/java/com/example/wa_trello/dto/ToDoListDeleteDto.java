package com.example.wa_trello.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class ToDoListDeleteDto {
    private Long id;

    @Builder
    public ToDoListDeleteDto(Long id) {
        this.id = id;
    }
}
