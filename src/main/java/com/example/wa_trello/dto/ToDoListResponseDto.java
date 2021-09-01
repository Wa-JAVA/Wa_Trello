package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import com.example.wa_trello.entity.ToDoList;
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

    public ToDoListResponseDto(ToDoList toDoList){
        this.id = toDoList.getId();
        this.cards = toDoList.getCards();
        this.title = toDoList.getTitle();
        this.order = toDoList.getOrder_Num();
    }
}
