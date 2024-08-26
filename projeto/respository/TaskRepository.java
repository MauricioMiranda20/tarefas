package com.example.projeto.respository;

import org.springframework.stereotype.Repository;
import com.example.projeto.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
