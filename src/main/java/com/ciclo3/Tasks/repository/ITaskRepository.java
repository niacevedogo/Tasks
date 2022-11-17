package com.ciclo3.Tasks.repository;

import com.ciclo3.Tasks.entities.Task;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.id = ?1")
    ArrayList<Task> validarTask(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.title = ?1,t.description = ?2, t.state = ?3 WHERE t.id = ?4")
    void setTaskInfoById(String title, String description, Enum enu, Integer taskId);

}
