package com.example.wa_trello.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoListUpdateRequestDto {
    private String title;

    @Builder
    public ToDoListUpdateRequestDto(String title) {
        this.title = title;
    }
}