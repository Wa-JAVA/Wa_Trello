package com.example.wa_trello.controller;

import com.example.wa_trello.Service.ListService;
import com.example.wa_trello.dto.ToDoListDeleteDto;
import com.example.wa_trello.dto.ToDoListSaveRequestDto;
import com.example.wa_trello.dto.ToDoListUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ListController {
    private ListService listService;

    @PostMapping("/lists") //Create List
    public Long saveList(@RequestBody ToDoListSaveRequestDto dto) {
        return listService.toDoListSave(dto);
    }

    @PutMapping("/lists/{id}") //Update List
    public Long updateList(@PathVariable("id") Long id, @RequestBody ToDoListUpdateRequestDto dto) {
        return listService.toDoListUpdate(id,dto);
    }

    @DeleteMapping("/lists/{id}") //Delete List
    public void deleteList(@RequestBody ToDoListDeleteDto dto) {
        listService.toDoListDelete(dto);
    }
}
