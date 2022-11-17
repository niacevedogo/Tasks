//package com.ciclo3.Tasks.services;
//
//import com.ciclo3.Tasks.entities.Profile;
//import com.ciclo3.Tasks.repository.IProfileRespository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProfileService {
//
//    private IProfileRespository profileRespository;
//
//    public ProfileService(IProfileRespository rep){
//        this.profileRespository = rep;
//    }
//
//    public Response createProfile (Profile data){
//        Response response = new Response();
//
//        this.profileRespository.save(data);
//
//        response.setCode(200);
//        response.setMessage("Usuario registrado exitosamente");
//        return  response;
//
//    }
//
//
//}
