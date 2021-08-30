package com.example.wa_trello.Service;

import com.example.wa_trello.dto.ToDoListDeleteDto;
import com.example.wa_trello.dto.ToDoListResponseDto;
import com.example.wa_trello.dto.ToDoListSaveRequestDto;
import com.example.wa_trello.dto.ToDoListUpdateRequestDto;
import com.example.wa_trello.entity.ToDoList;
import com.example.wa_trello.repository.ToDoListRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class ListService {
    private ToDoListRepository toDoListRepository;

    @Transactional
    public Long toDoListSave(ToDoListSaveRequestDto toDoListSaveRequestDto){
        return toDoListRepository.save(toDoListSaveRequestDto.toEntity()).getId;
    }

    @Transactional(readOnly = true)
    public List<ToDoListResponseDto> toDoListFindAll(){
        return toDoListRepository.findAll()
                .Stream()
                .map(ToDoListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ToDoListResponseDto toDoListFindById(Long id){
        ToDoList toDoList = toDoListRepository.findById(id);
        return ToDoListResponseDto(toDoList);
    }

    @Transactional
    public void toDoListDelete(ToDoListDeleteDto toDoListDeleteDto) {
        Long id = ToDoListDeleteDto.getId;
        toDoListRepository.deleteById(id);
    }

    @Transactional
    public Long toDoListUpdate(Long id, ToDoListUpdateRequestDto toDoListUpdateRequestDto){
        toDoListRepository.update(id,toDoListUpdateRequestDto.getTitle);
        return id;
    }

}
