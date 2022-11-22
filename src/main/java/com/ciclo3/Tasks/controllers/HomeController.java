package com.ciclo3.Tasks.controllers;


import com.ciclo3.Tasks.entities.Users;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Setter
@Getter
@Controller
public class HomeController extends BaseController {

    @GetMapping("inicio")
    public RedirectView inicio(Model data){ //@AuthenticationPrincipal OidcUser principal

//        Users user = new Users();
//        user = seguridad();
//        if(principal != null){
//           Map<String,Object> Auth0Data = principal.getClaims();
//           String username =(String) Auth0Data.get("name");
//           user = this.service.selectByUserName(username);
//        }
//        else{
//
//        }
//        data.addAttribute("usuarioautenticado",user);
        //return "home/inicio";
        return new RedirectView("/task/index");
    }
//
//
//    @GetMapping("consume")
//    public String consume(Model data,@AuthenticationPrincipal OidcUser principal) throws IOException, InterruptedException {
//        Users user = new Users();
//        if(principal != null){
//            Map<String,Object> Auth0Data = principal.getClaims();
//            String username =(String) Auth0Data.get("name");
//            user = this.service.selectByUserName(username);
//        }
//        else{
//            user = seguridad();
//        }
//
//        data.addAttribute("usuarioautenticado",user);
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/"))
//                .GET()
//                .build();
//
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.statusCode());
//        System.out.println(response.body());
//
//        /*ObjectMapper mapper = new ObjectMapper();
//        PokemonDTO pokemons = mapper.readValue(response.body(), PokemonDTO.class);
//        System.out.println("Cantidad de pokemones" + pokemons.getCount());
//        data.addAttribute("cantidad",pokemons.getCount());*/
//        return "home/consume";
//    }

}
