package com.example.wa_trello.controller;

import com.example.wa_trello.Service.ListService;
import com.example.wa_trello.dto.ToDoListSaveRequestDto;
import com.example.wa_trello.entity.Card;
import com.example.wa_trello.entity.ToDoList;
import com.example.wa_trello.repository.CardRepository;
import com.example.wa_trello.repository.ToDoListRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private ToDoListRepository toDoListRepository;
    private CardRepository cardReopsitory;

    @Test
    public void toDOListSaveTest() {
        String toDoListTitle = "List1";
        int order = 0;
        cardReopsitory.save(Card.builder().title("Card1").order(0).build());

        ToDoListSaveRequestDto toDoListSaveRequestDto = ToDoListSaveRequestDto.builder()
                .cards(cardReopsitory.findAll())
                .order(order)
                .title(toDoListTitle)
                .build();

        ResponseEntity<ToDoList> responseEntity = restTemplate.postForEntity("/list", toDoListSaveRequestDto, ToDoList.class);
        ToDoList toDoList = responseEntity.getBody();

        assertThat(HttpStatus.CREATED).isEqualTo(responseEntity.getStatusCode());

    }
}
