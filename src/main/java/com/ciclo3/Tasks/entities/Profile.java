package com.ciclo3.Tasks.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile extends Users{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "usersP")
    private Users usersP;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column (name = "createdAt")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(name = "updatedAt")
    private Date updatedAt;



}
