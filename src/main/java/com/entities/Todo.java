package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int todoId;
	private String todoTitle;
	private String todoContent;
	private Date tododate;
	
	
	
	public Todo() {
		
	}

	public Todo(String todoTitle, String todoContent, Date tododate) {
		super();
		this.todoTitle = todoTitle;
		this.todoContent = todoContent;
		this.tododate = tododate;
	}
	
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	public Date getTododate() {
		return tododate;
	}
	public void setTododate(Date tododate) {
		this.tododate = tododate;
	}

	@Override
	public String toString() {
		return "Todo [todoTitle=" + todoTitle + ", todoContent=" + todoContent + ", tododate=" + tododate + "]";
	}
	
	
}
