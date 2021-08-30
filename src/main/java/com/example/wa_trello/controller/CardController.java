package com.example.wa_trello.controller;

import com.example.wa_trello.Service.CardService;
import com.example.wa_trello.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CardController {
    private CardService cardService;

    @PostMapping("/cards") //Create List
    public Long saveCard(@RequestBody CardSaveRequestDto dto) {
        return cardService.cardSave(dto);
    }

    @PutMapping("/cards/:id") //Update List
    public Long updateCard(@PathVariable("id") Long id, @RequestBody CardUpdateRequestDto dto) {
        return cardService.cardUpdate(id,dto);
    }

    @DeleteMapping("/cards/:id") //Delete List
    public void deleteCard(@RequestBody CardDeleteDto dto) {
        cardService.cardDelete(dto);
    }
}
