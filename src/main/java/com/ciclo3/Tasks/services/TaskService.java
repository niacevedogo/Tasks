package com.ciclo3.Tasks.services;

import com.ciclo3.Tasks.entities.Task;
import com.ciclo3.Tasks.repository.ITaskRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.PreparedStatement;
import java.util.ArrayList;

@Setter
@Getter
@Service
public class TaskService {

    private ITaskRepository taskRepository;

    public TaskService (ITaskRepository rep){
        this.taskRepository = rep;
    }

    public Response CreateTask(Task data){

        Response response = new Response();

        this.taskRepository.save(data);

        response.setCode(200);
        response.setMessage("Tarea registrada correctamente");
        return response;

    }

    public ArrayList<Task> selectAll(){
        return (ArrayList<Task>) this.taskRepository.findAll();
    }

    public Response updateTask(Task data){
        Response response = new Response();

        ArrayList<Task> existe = this.taskRepository.validarTask(data.getId());

        if ( existe != null && existe.size() >0){
            this.taskRepository.setTaskInfoById(data.getTitle(),data.getDescription(),data.getState(),data.getId());
            response.setCode(200);
            response.setMessage("la tarea existe y se modificó");
            return response;
        }

        response.setCode(500);
        response.setMessage("no existe la tarea");
        return response;

    }

    public Response deleteTaskById(int Id){
        Response response = new Response();
        try {
            this.taskRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Tarea eliminado exitosamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error" + ex.getMessage());
            return response;
        }
    }



}
