package com.example.wa_trello.controller;

import com.example.wa_trello.Service.CardService;
import com.example.wa_trello.Service.ListService;
import com.example.wa_trello.dto.CardResponseDto;
import com.example.wa_trello.dto.ToDoListResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MainController {
    private ListService listService;
    private CardService cardService;

    @GetMapping("/") //List + Card를 표시
    public String findAllList(Model model) {
        model.addAttribute("lists", listService.toDoListFindAll());
        return "main";
    }

    @GetMapping("/lists/{id}") //Read List
    public String findByIdList(@PathVariable("id") Long id, Model model) {
        ToDoListResponseDto dto = listService.toDoListFindById(id);
        model.addAttribute("lists", dto);
        return "list";
    }

    @GetMapping("/cards/{id}") //Read Card
    public String findByIdCard(@PathVariable("id") Long id, Model model) {
        CardResponseDto dto = cardService.cardFindById(id);
        model.addAttribute("card", dto);
        return "card"; 
    }
}
