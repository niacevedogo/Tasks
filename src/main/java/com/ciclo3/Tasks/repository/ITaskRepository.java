package com.ciclo3.Tasks.repository;

import com.ciclo3.Tasks.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {
}
