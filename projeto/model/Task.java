package com.example.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity
public class Task {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Getter//esse é usado pelo lombok para user get
	private long id;
	private String title;
	private String description;
	private boolean completed;
	public Task() {
		super();
	}
	public Task(long id, String title, String description, boolean completed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}	
}
