package com.example.wa_trello.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MainControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지() {
        //when
        String main = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(main).contains("메인페이지");
    }

    @Test
    public void 리스트페이지() {
        //when
        String list = this.restTemplate.getForObject("/lists/{id}", String.class);

        //then
        assertThat(list).contains("리스트페이지");
    }

    @Test
    public void 카드페이지() {
        //when
        String card = this.restTemplate.getForObject("/cards/{id}", String.class);

        //then
        assertThat(card).contains("카드페이지");
    }
}
