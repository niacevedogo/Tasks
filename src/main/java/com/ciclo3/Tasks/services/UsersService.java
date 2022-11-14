package com.ciclo3.Tasks.services;

import com.ciclo3.Tasks.entities.Users;
import com.ciclo3.Tasks.repository.IProfileRespository;
import com.ciclo3.Tasks.repository.IUsersRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@Service
public class UsersService {

    private IUsersRepository usersRepository;

    public UsersService(IUsersRepository rep){
        this.usersRepository = rep;
    }

    // Esta metodo se sacò de itnernet para validar si el email es valido
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }


    public Response createUser(Users data){
        // se instancia la clase
        Response response = new Response();

        if (!isValidEmailAddress(data.getEmail())){
            response.setCode(500);
            response.setMessage("El usuario dado no es válido");
            return response;
        }
        ArrayList<Users> existe  = this.usersRepository.existeCorreo(data.getEmail());
        if (existe != null && existe.size() >0){
            response.setCode(500);
            response.setMessage("El correo electrònico ya esta en uso");
            return response;
        }
        // validamos password
        if(data.getPassword().equals("") || data.getPassword().equals(null)){
            response.setCode(500);
            response.setMessage("su contraseña no es valida");
            return response;
        }
        this.usersRepository.save(data);


        response.setCode(200);
        response.setMessage("Usuario registrado exitosamente");
        return  response;

    }

    public ArrayList<Users> selectAll(){
        return (ArrayList<Users>) this.usersRepository.findAll();
        // hace un Select * from y retorna de la base in listados de los usuarios
    }

    // encontrar por Id
    public Users selectById(int Id){
        Optional<Users> existe = this.usersRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }

    // Eliminar un usuario
    public Response deleteUserById(int Id){
        Response response = new Response();
        try {
            this.usersRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Usuario eliminado exitosamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error" + ex.getMessage());
            return response;
        }
    }

    // update basico se hace por llave primaria
    public Response updateUser(Users data){
        Response response = new Response();

        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error el Id del usuario no es valido");
            return response;
        }

        // Validar si el usuario a actualiar existe
        // podemos usar un método que ya existe
        Users exists = (Users) selectById(data.getId());
        if (exists == null){
            response.setCode(500);
            response.setMessage("Error el usuario no existe");
            return response;
        }

        if (data.getEmail().equals(null) || data.getEmail().equals("")){
            response.setCode(500);
            response.setMessage("Error Correo no valido");
            return response;
        }

        if (!isValidEmailAddress(data.getEmail())){
            response.setCode(500);
            response.setMessage("Error formato de correo no valido");
            return response;
        }

        exists.setEmail(data.getEmail());
        this.usersRepository.save(exists);
        response.setCode(500);
        response.setMessage("Usuario actualizado correctamente");
        return response;
    }

    public Response loginUnser (Users data){
        Response response = new Response();

        //Logia de negocio
        //Validamos los datos

        if (!isValidEmailAddress(data.getEmail())){
            response.setCode(500);
            response.setMessage("El correo es no válido");
            return response;
        }

        // validamos password
        if(data.getPassword().equals("") || data.getPassword().equals(null)){
            response.setCode(500);
            response.setMessage("su contraseña no es valida");
            return response;
        }

        ArrayList<Users> existe = this.usersRepository.validaCredenciales(data.getEmail(), data.getPassword());

        if(existe != null && existe.size() > 0){
            response.setCode(200);
            response.setMessage("usuario autenticado exitosamente");
            return response;
        }
        response.setCode(500);
        response.setMessage("sus datos de acceso no son validos");
        return response;
    }

}
