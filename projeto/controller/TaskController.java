package com.example.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.model.Task;
import com.example.projeto.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping("POST /api/tasks")
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@GetMapping("GET /api/task")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("GET /api/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id){
		return taskService.getTaskById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("PUT /api/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task details){
		return ResponseEntity.ok(taskService.updatetask(id, details));
	}
	
	@DeleteMapping("DELETE /api/tasks/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
