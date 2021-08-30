package com.example.wa_trello.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ToDoList {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
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
