package com.ciclo3.Tasks.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column (name = "createdAt")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(name = "updatedAt")
    private Date updatedAt;

    @OneToOne
    @JoinColumn (name = "profile")
    private Profile profile;

    /*@OneToMany
    @JoinColumn(name = "tasks")
    private Task tasks;*/


}
