package com.example.wa_trello.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @OneToMany
    private List<Card> cards;

    @Column
    private String title;

    @Column
    private int order;

    @Builder
    public ToDoList(List<Card> cards, String title, int order){
        this.cards = cards;
        this.title = title;
        this.order = order;
    }
}
