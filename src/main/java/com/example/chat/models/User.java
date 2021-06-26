package com.example.chat.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    public User(){
        
    }

    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }
}