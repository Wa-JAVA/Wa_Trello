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

    @Builder
    public CardResponseDto(String title, int order, long id) {
        this.title = title;
        this.order = order;
        this.id = id;
    }
}
