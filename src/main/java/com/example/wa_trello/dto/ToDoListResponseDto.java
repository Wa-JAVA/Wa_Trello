package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ToDoListResponseDto {
    private List<Card> cards;
    private String title;
    private int order;
    private Long id;

    @Builder
    public ToDoListResponseDto(List<Card> cards, String title, int order, long id) {
        this.cards = cards;
        this.title = title;
        this.order = order;
        this.id = id;
    }
}
