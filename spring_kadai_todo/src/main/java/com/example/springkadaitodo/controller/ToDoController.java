package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	 private final ToDoService todoService;

	    public ToDoController(ToDoService todoService) {
	        this.todoService = todoService;
	    }

	    @GetMapping("/todo")
	    public String first(Model model) {
	       List<ToDo> todos = todoService.getAllTodos();
	        model.addAttribute("todos", todos);
	        return "todoView";
	    }
	
	
	
/*自分で描いたもの
	@GetMapping("/")
	public String first(Model model) {
		List<ToDo> todos = todoService.getAllTodos();
		model.addAttribute("todos", todos);
		return "todoView";
	} */
	

}
