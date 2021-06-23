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

}