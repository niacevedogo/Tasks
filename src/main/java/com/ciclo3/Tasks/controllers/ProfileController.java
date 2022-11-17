//package com.ciclo3.Tasks.controllers;
//
//
//import com.ciclo3.Tasks.entities.Profile;
//import com.ciclo3.Tasks.services.ProfileService;
//import com.ciclo3.Tasks.services.Response;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Setter
//@Getter
//@RestController
//@RequestMapping("profile")
//public class ProfileController {
//
//    private ProfileService profileService;
//
//    public ProfileController(ProfileService service){
//        this.profileService = service;
//    }
//
//
//
//    public Response createProfile(@RequestBody Profile request){
//        return this.profileService.createProfile(request);
//    }
//
//
//
//
//}
