package com.example.wa_trello.repository;

import com.example.wa_trello.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card,Long> {
    @Modifying(flushAutomatically = true, clearAutomatically = true)  //update시 @Modifying 어노테이션 추가함
    @Query(value = "update Card C SET C.title = ?2 where C.id = ?1")
    int updateContent(Long id, String title);

    @Modifying
    @Query(value = "update Card C SET C.order = ?2 where C.id = ?1")
    int updateOrder(Long id, int order);
}
