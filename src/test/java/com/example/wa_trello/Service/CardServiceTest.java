package com.example.wa_trello.Service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.wa_trello.dto.CardDeleteDto;
import com.example.wa_trello.dto.CardResponseDto;
import com.example.wa_trello.dto.CardSaveRequestDto;
import com.example.wa_trello.dto.CardUpdateRequestDto;
import com.example.wa_trello.entity.Card;
import com.example.wa_trello.repository.CardReopsitory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardReopsitory cardReopsitory;

    @After
    public void cleanup() {cardReopsitory.deleteAll();}

    @Test
    public void Dto데이터저장() {
        CardSaveRequestDto dto = CardSaveRequestDto.builder()
                .title("타이틀")
                .order(1)
                .build();

        cardService.cardSave(dto);

        Card card = cardReopsitory.findAll().get(0);
        assertThat(card.getTitle()).isEqualTo(dto.getTitle());
        assertThat(card.getOrder()).isEqualTo(dto.getOrder());
    }

    @Test
    public void Dto데이터수정() {
        CardSaveRequestDto saveDto = CardSaveRequestDto.builder()
                .title("타이틀")
                .order(1)
                .build();
        Long id = cardService.cardSave(saveDto);

        CardUpdateRequestDto dto = CardUpdateRequestDto.builder()
                .title("타이틀이예요")
                .build();

        cardService.cardUpdate(id, dto);
        Card card = cardReopsitory.findAll().get(0);
        assertThat(card.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void Dto데이터삭제() {
        CardSaveRequestDto saveDto = CardSaveRequestDto.builder()
                .title("타이틀")
                .order(1)
                .build();
        Long id = cardService.cardSave(saveDto);

        CardDeleteDto dto = CardDeleteDto.builder()
                .id(id)
                .build();
        cardService.cardDelete(dto);
    }
/*
    @Test
    public void Dto데이터_뷰() {
        Card card;
        CardSaveRequestDto saveDto = CardSaveRequestDto.builder()
                .title("타이틀")
                .order(1)
                .build();
        Long id = cardService.cardSave(saveDto);

        CardResponseDto dto = CardResponseDto.builder()

    }*/
}
