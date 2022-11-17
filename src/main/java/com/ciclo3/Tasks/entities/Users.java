package com.ciclo3.Tasks.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    //@DateTimeFormat(pattern = "dd-MM-yyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @Column (name = "createdAt", nullable = false, updatable = false)
    private Date createdAt = new Date();

    //@DateTimeFormat(pattern = "dd-MM-yyy")
    //@Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @Column(name = "updatedAt", nullable = false, updatable = false)
    private Date updatedAt = new Date();

//    @OneToOne
//    @JoinColumn (name = "profile")
//    private Profile profile;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = ("users"), fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "tasks")
    @JsonManagedReference
    private List<Task> tasks;
    //  Cuando la relaciòn es UNO a MUCHOS se debe usar LIST<E>

}
