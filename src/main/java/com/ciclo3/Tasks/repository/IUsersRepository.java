package com.ciclo3.Tasks.repository;

import com.ciclo3.Tasks.entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {

    public
    @Query("SELECT u FROM Users u WHERE u.email = ?1 and u.password = ?2")
    ArrayList<Users> validaCredenciales(String usuario, String password);

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    ArrayList<Users> existeCorreo(String email);

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    Users finByUserName(String email);




}
