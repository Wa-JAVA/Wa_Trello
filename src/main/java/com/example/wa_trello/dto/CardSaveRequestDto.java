package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardSaveRequestDto {
    private String title;
    private int order;

    @Builder
    public CardSaveRequestDto(String title, int order) {
        this.title = title;
        this.order = order;
    }

    public Card toEntity() {
        return Card.builder()
                .title(title)
                .order(order)
                .build();
    }
}
