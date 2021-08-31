package com.example.wa_trello.repository;

import com.example.wa_trello.entity.Card;
import com.example.wa_trello.entity.ToDoList;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoListRepositroyTest {
    @Autowired
    ToDoListRepository toDoListRepository;
    @Autowired
    CardRepository cardRepository;

    @After
    public void cleanUp() {
        toDoListRepository.deleteAll();
        cardRepository.deleteAll();
    }

    @Test
    public void listRepositorySaveTest(){
        cardRepository.save(Card.builder().title("카드0").order(0).build());
        cardRepository.save(Card.builder().title("카드1").order(1).build());

        toDoListRepository.save(ToDoList.builder().title("리스트1").cards(cardRepository.findAll()).order(0).build());

        List<ToDoList> toDoLists = toDoListRepository.findAll();

        ToDoList toDoList = toDoLists.get(0);

        assertThat(toDoList.getTitle(),is("리스트1"));
        assertThat(toDoList.getOrder(),is(0));
        assertThat(toDoList.getCards().get(0).getTitle(),is(cardRepository.findAll().get(0).getTitle()));

    }


}
