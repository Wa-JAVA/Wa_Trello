package com.example.wa_trello.Service;

import com.example.wa_trello.dto.*;
import com.example.wa_trello.entity.Card;
import com.example.wa_trello.entity.ToDoList;
import com.example.wa_trello.repository.CardRepository;
import com.example.wa_trello.repository.ToDoListRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListServiceTest {

    @Autowired
    private ListService listService;

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private CardRepository cardRepository;

    @After
    public void cleanUp() {
        toDoListRepository.deleteAll();
        cardRepository.deleteAll();
    }

    @Test
    public void toDoListSaveTest() {
        cardRepository.save(Card.builder()
                .title("Card1")
                .order(0)
                .build());

        ToDoListSaveRequestDto toDoListSaveRequestDto = ToDoListSaveRequestDto.builder()
                .title("List1")
                .order(0)
                .cards(cardRepository.findAll())
                .build();

        listService.toDoListSave(toDoListSaveRequestDto);

        ToDoList toDoList = toDoListRepository.findAll().get(0);
        assertThat(toDoList.getCards().get(0).getTitle()).isEqualTo(toDoListSaveRequestDto.getCards().get(0).getTitle());
        assertThat(toDoList.getCards().get(0).getOrder()).isEqualTo(toDoListSaveRequestDto.getCards().get(0).getOrder());
        assertThat(toDoList.getOrder_Num()).isEqualTo(toDoListSaveRequestDto.getOrder());
        assertThat(toDoList.getTitle()).isEqualTo(toDoListSaveRequestDto.getTitle());
    }

    @Test
    public void toDoListServiceUpdate(){
        cardRepository.save(Card.builder()
                .title("Card1")
                .order(0)
                .build());

        ToDoListSaveRequestDto toDoListSaveRequestDto = ToDoListSaveRequestDto.builder()
                .title("List1")
                .order(0)
                .cards(cardRepository.findAll())
                .build();

         Long id = listService.toDoListSave(toDoListSaveRequestDto);

        ToDoListUpdateRequestDto updateRequestDto = ToDoListUpdateRequestDto.builder()
                .title("리스트1")
                .build();

        listService.toDoListUpdate(id,updateRequestDto);

        ToDoList toDoList = toDoListRepository.findAll().get(0);

        assertThat(toDoList.getTitle()).isEqualTo("리스트1");
    }

    @Test
    public void toDoListDeleteTest(){
        cardRepository.save(Card.builder()
                .title("Card0")
                .order(0)
                .build());
        cardRepository.save(Card.builder()
                .title("Card1")
                .order(1)
                .build());
        ToDoListSaveRequestDto toDoListSaveRequestDto = ToDoListSaveRequestDto.builder()
                .title("List1")
                .order(0)
                .cards(cardRepository.findAll())
                .build();
        Long id1 = listService.toDoListSave(toDoListSaveRequestDto);

        ToDoListDeleteDto toDoListDeleteDto = ToDoListDeleteDto.builder().id(id1).build();

        listService.toDoListDelete(toDoListDeleteDto);

        Long size = toDoListRepository.count();

        assertThat(size).isEqualTo(0L);
    }
}
