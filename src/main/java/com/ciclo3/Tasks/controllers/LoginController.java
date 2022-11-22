package com.ciclo3.Tasks.controllers;


import com.ciclo3.Tasks.dto.registroDTO;
import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.services.Response;
import com.ciclo3.Tasks.services.UsersService;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Setter
@Getter
@Controller
public class LoginController {

    private UsersService service;
//    private TipoDocumentoService docService;

//    public LoginController(UsersService service,TipoDocumentoService docService){
//        this.service = service ;
//        this.docService = docService;
//    }

    public LoginController(UsersService service){
        this.service = service ;
    }

    @GetMapping("/")
    public String root(){
        return "login/login";
    }
    @GetMapping("login")
    public String login(){
        return "login/login";
    }

//    @GetMapping("registro")
//    public String registro(Model tiposdocumento){
//        //Cargamos los documentos desde la logica de negocio.
//        ArrayList<TipoDocumento> tiposDocumentoDB = this.docService.selectAll();
//        //Pasamos la infomación al model de thymeleaf
//        tiposdocumento.addAttribute("misdocumentos",tiposDocumentoDB);
//        tiposdocumento.addAttribute("texto","Bienvenidos");
//
//        return "login/registro";
//    }

    @PostMapping("postlogin")
    public RedirectView postlogin(Users data){
        Response response = this.service.loginUser(data);
        if(response.getCode() == 200){
            return new RedirectView("/inicio");
        }
        else{
            return new RedirectView("/error2");
        }
    }

    @PostMapping("postregistro")
    public RedirectView postregisto(registroDTO data){

        if(data.getPassword().equals(null) || data.getPassword().equals("")){
            System.out.println("Contraseña no valida");
            return new RedirectView("/error2");
        }
        if(!data.getPassword().equals(data.getValidaPassword())){
            System.out.println("Las contraseñas no coinciden.");
            return new RedirectView("/error2");
        }


        Users user = new Users();
        //Mapping
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        user.setApellido(data.getApellidos());
        user.setNombre(data.getNombres());
//        user.setNumeroDocumento(data.getNumeroDocumento());
//        user.setTipoDocumento(data.getTipoDocumento());

        Response response = this.service.createUser(user);
        System.out.println(response.getMessage());
        if(response.getCode() == 200){
            return new RedirectView("/login");
        }
        else{
            return new RedirectView("/error2");
        }
    }

    @GetMapping("error2")
    public String error(){
        return "login/error";
    }


//    @GetMapping("registro")
//    public String registro(Model tiposdocumento){
//        //Cargamos los documentos desde la logica de negocio.
//        ArrayList<TipoDocumento> tiposDocumentoDB = this.docService.selectAll();
//        //Pasamos la infomación al model de thymeleaf
//        tiposdocumento.addAttribute("misdocumentos",tiposDocumentoDB);
//        tiposdocumento.addAttribute("texto","Bienvenidos");
//
//        return "login/registro";
//    }

    @GetMapping("registro")
    public String registro(){
        return "login/registro";
    }
}
