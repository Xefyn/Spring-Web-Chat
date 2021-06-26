package com.example.chat.models;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name= "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="userReceiverId")
    private Long userReceiverId;

    @Column(name="userSenderId")
    private Long userSenderId;

    @Column(name="message")
    private String message;

    @Column(name="createdAt")
    private String createdAt;
    
    public Chat(){
        
    }

    public Chat(int id, int userReceiverId, int userSenderId, String message, String date){
        this.id = Long.valueOf(id);
        this.userReceiverId = Long.valueOf(userReceiverId);
        this.userSenderId = Long.valueOf(userSenderId);
        this.message = message;
        this.createdAt = date;
    }
}