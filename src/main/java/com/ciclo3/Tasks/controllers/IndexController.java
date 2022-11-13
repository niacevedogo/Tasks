package com.ciclo3.Tasks.controllers;

import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.services.Response;
import com.ciclo3.Tasks.services.UsersService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("index")
public class IndexController {


    private UsersService usersService;

    public IndexController(UsersService service){
        this.usersService = service;
    }


    @PostMapping("create")  //@RequestBody lo que se recibe esta en formato JSON
    public Response createUser(@RequestBody Users request){
        // especificar que información recibe para guardarla
        return this.usersService.createUser(request);

    }

    @RequestMapping("getusuarios")
    public ArrayList<Users> getUsuarios(){
        return this.usersService.selectAll();
    }



}
