package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import com.example.wa_trello.entity.ToDoList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor

public class ToDoListSaveRequestDto {
    private List<Card> cards;
    private String title;
    private int order;

    @Builder
    public ToDoListSaveRequestDto(List<Card> cards, String title, int order) {
        this.cards = cards;
        this.title = title;
        this.order = order;
    }

    public ToDoList toEntity() {
        return ToDoList.builder()
                .cards(cards)
                .title(title)
                .order(order)
                .build();
    }
}
