package com.example.wa_trello.repository;

import com.example.wa_trello.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {
    @Modifying(flushAutomatically = true, clearAutomatically = true) //flush,clear는 혹시 모를 기존의 영속성 컨텍스트에 남아있는 쿼리르 수행하기 위해
    // 벌크성(다건의 update,delete를 하나의 쿼리로 하는 것) 수정 쿼리
    @Query(value = "update ToDoList T SET T.title = ?2 where T.id = ?1")
    int updateTitle(Long id, String title);

    @Modifying
    @Query(value = "update ToDoList T SET T.order = ?2 where T.id = ?1")
    Long updateOrder(Long id, int order);

}
