package com.example.wa_trello.repository;

import com.example.wa_trello.entity.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepositoryTest {
    @Autowired
    CardRepository cardRepository;

    @Test
    public void 카드저장_불러오기(){
        cardRepository.save(Card.builder()
                .title("카드1")
                .order(0)
                .build());

        List<Card> cards = cardRepository.findAll();

        Card card = cards.get(0);
        assertThat(card.getTitle(),is("카드1"));
        assertThat(card.getOrder(),is(0));
    }
}
