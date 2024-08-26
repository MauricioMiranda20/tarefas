package com.example.projeto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.respository.TaskRepository;
import com.example.projeto.model.Task;

import java.util.List;
import java.util.Optional;




@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks(){
		
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(long id){
		return taskRepository.findById(id);
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task updatetask(Long id,Task Details) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found for this id :"+id));
		
		task.setTitle(Details.getTitle());
		task.setDescription(Details.getDescription());
		task.setCompleted(Details.isCompleted());
		
		return taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found for this id"+id));
		taskRepository.delete(task);
	}
}
