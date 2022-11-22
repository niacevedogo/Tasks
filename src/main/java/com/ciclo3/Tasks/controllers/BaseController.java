package com.ciclo3.Tasks.controllers;

import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.services.UsersService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
@Setter
@Getter
@Controller
public class BaseController {

    @Autowired
    protected UsersService service;


//    protected Users seguridad(){
//        Users user;
//
//        //ingreso a la información de spring security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //Tomo el correo electronico que nos guardo spring securiy
//        String currentPrincipalName = authentication.getName();
//        user = this.service.selectByUserName(currentPrincipalName);
//        return  user;
//    }
}
