package com.ciclo3.Tasks.controllers;

import com.ciclo3.Tasks.entities.Task;
import com.ciclo3.Tasks.services.Response;
import com.ciclo3.Tasks.services.TaskService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Setter
@Getter
@RestController
@RequestMapping("task1")
public class TaskController {

    private TaskService taskService;

    public TaskController (TaskService service){
        this.taskService = service;
    }

    @PostMapping("create")
    public Response createTask(@RequestBody Task request){
        return this.taskService.CreateTask(request);
    }

    @GetMapping("gettasks")
    public ArrayList<Task> getTask(){
        return this.taskService.selectAll();
    }

    @PostMapping("update")
    public Response updateTask(@RequestBody Task request){
        return this.taskService.updateTask(request);

    }

    @DeleteMapping("delete")
    public Response deleteTask(@RequestBody Task request){
        return this.taskService.deleteTaskById(request.getId());
    }



}
