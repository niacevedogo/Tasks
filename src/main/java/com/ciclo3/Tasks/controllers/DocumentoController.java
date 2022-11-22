package com.ciclo3.Tasks.controllers;


import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.services.Response;
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
@RequestMapping("user")
public class DocumentoController {

    private UsersService service;

    public DocumentoController(UsersService ser){
        this.service = ser;
    }


    @GetMapping("index")
    public String index(Model documentos){
        //Consulto los documentos a la base de datos por medio de la logica de negocio
        ArrayList<Users> documentosDB = this.service.selectAll();
        //Armo el modelo que se le pasa a thymeleaf
        documentos.addAttribute("misusuarios",documentosDB);
        return "documento/index";
    }


    @GetMapping("create")
    public String create(){
        return "documento/create";
    }

    @PostMapping("createdoc")
    public RedirectView create(Users data){
        Response response = this.service.createUser(data);
        return new RedirectView("/user/index");
    }
}
