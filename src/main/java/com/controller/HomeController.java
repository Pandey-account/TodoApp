package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.TodoDao;
import com.entities.Todo;

import jakarta.servlet.ServletContext;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;
	@Autowired
	TodoDao todoDao;

	@RequestMapping("/home")
	public String home(Model m) {

		String str = "home";
		m.addAttribute("page", str);
		List<Todo> list = this.todoDao.getAll();
		m.addAttribute("todos", list);
		return "home";
	}

	@RequestMapping("/add")
	public String AddTodo(Model m) {

		Todo t = new Todo();

		m.addAttribute("page", "add");
		m.addAttribute("todo", t);
		return "home";
	}

	@RequestMapping(path = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
		System.out.println(t);
		t.setTododate(new Date());
		this.todoDao.save(t);
		m.addAttribute("msg", "Successfully added...");

		return "home";
	}
}
