package com.ciclo3.Tasks.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column (name = "createdAt")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "state")
    private EnumState state;




}