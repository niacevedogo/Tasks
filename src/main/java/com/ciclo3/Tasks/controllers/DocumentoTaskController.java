package com.ciclo3.Tasks.controllers;


import com.ciclo3.Tasks.entities.Task;
import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.services.Response;
import com.ciclo3.Tasks.services.TaskService;
import com.ciclo3.Tasks.services.UsersService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
@Setter
@Getter
@Controller
@RequestMapping("task")
public class DocumentoTaskController {


    private TaskService service;

    public DocumentoTaskController (TaskService ser){
        this.service = ser;
    }


    @GetMapping("index")
    public String index(Model documentos){
        //Consulto los documentos a la base de datos por medio de la logica de negocio
        ArrayList<Task> documentosDB = this.service.selectAll();
        //Armo el modelo que se le pasa a thymeleaf
        documentos.addAttribute("mistask",documentosDB);
        return "task/indext";
    }



    @GetMapping("create")
    public String create(){
        return "task/createt";
    }







    @PostMapping("createtask")
    public RedirectView create(Task data){
        Task task = new Task();
        task.setTitle(data.getTitle());
        task.setDescription(data.getDescription());
        task.setState(data.getState());

        Response response = this.service.CreateTask(task);

        System.out.println(response.getMessage());
        if(response.getCode() == 200){
            return new RedirectView("/task/indext");
        }
        else{
            return new RedirectView("/error2");
        }

    }
}
