package com.example.chat.controllers;

import com.example.chat.models.User;
import com.example.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String renderPage() {
    return "chat";
    // return new ModelAndView("chat");
  }

  @GetMapping("/user/getAll")
  public List<User> all() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> createMember(@PathVariable(value= "id") Long id) {
    return ResponseEntity.ok(userService.findUserById(id));
  }
}