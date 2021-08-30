package com.example.wa_trello.dto;

import com.example.wa_trello.entity.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardUpdateRequestDto {
    private String title;

    @Builder
    public CardUpdateRequestDto(String title) {
        this.title = title;
    }
}