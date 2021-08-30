package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Getter
@NoArgsConstructor
public class CardResponseDto {
    private String title;
    private int order;
    private Long id;

    public CardResponseDto(Card card) {
        this.title = card.getTitle();
        this.order = card.getOrder();
        this.id = card.getId();
    }
}
