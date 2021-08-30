package com.example.wa_trello.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardDeleteDto {
    private Long id;

    @Builder
    public CardDeleteDto(Long id) {
        this.id = id;
    }
}
