package com.example.wa_trello.Service;

import com.example.wa_trello.dto.CardDeleteDto;
import com.example.wa_trello.dto.CardResponseDto;
import com.example.wa_trello.dto.CardSaveRequestDto;
import com.example.wa_trello.dto.CardUpdateRequestDto;
import com.example.wa_trello.entity.Card;
import com.example.wa_trello.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    @Transactional
    public Long cardSave(CardSaveRequestDto cardSaveRequestDto){
        return cardRepository.save(cardSaveRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public CardResponseDto cardFindById(Long id){
        Card card = cardRepository.findById(id).orElseThrow(()->new  IllegalAccessError("[Card=]"+id+"] 가 없습니다."));
        return new CardResponseDto(card);
    }

    @Transactional
    public void cardDelete(CardDeleteDto cardDeleteDto){
        Long id = cardDeleteDto.getId();
        cardRepository.deleteById(id);
    }

    @Transactional
    public Long cardUpdate(Long id, CardUpdateRequestDto cardUpdateRequestDto){
        cardRepository.updateContent(id,cardUpdateRequestDto.getTitle());
        return id;
    }
}
