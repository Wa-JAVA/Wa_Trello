package com.example.wa_trello.Service;

import com.example.wa_trello.dto.CardDeleteDto;
import com.example.wa_trello.dto.CardResponseDto;
import com.example.wa_trello.dto.CardSaveRequestDto;
import com.example.wa_trello.dto.CardUpdateRequestDto;
import com.example.wa_trello.entity.Card;
import com.example.wa_trello.repository.CardReopsitory;
import org.springframework.transaction.annotation.Transactional;

public class CardService {

    private CardReopsitory cardReopsitory;

    @Transactional
    public Long cardSave(CardSaveRequestDto cardSaveRequestDto){
        return cardReopsitory.save(cardSaveRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public CardResponseDto cardFindById(Long id){
        Card card = cardReopsitory.findById(id).orElseThrow(()->new  IllegalAccessError("[Card=]"+id+"] 가 없습니다."));
        return new CardResponseDto(card);
    }

    @Transactional
    public void cardDelete(CardDeleteDto cardDeleteDto){
        Long id = cardDeleteDto.getId();
        cardReopsitory.deleteById(id);
    }

    @Transactional
    public Long cardUpdate(Long id, CardUpdateRequestDto cardUpdateRequestDto){
        cardReopsitory.updateContent(id,cardUpdateRequestDto.getTitle());
        return id;
    }
}
