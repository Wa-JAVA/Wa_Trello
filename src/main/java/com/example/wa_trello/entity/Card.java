package com.example.wa_trello.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;
    
    @Column
    private int order;

    @Builder
    public Card(String title, int order){ //리턴타입 쓰지 않아 메소드 선언이 잘못된 경우란 오류 뜸
        this.title = title;
        this.order = order;
    }

}

// build tool -> gradle -> intellij로 변경