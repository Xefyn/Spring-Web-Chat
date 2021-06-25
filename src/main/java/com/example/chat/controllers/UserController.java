package com.example.chat.controllers;

import com.example.chat.models.User;
import com.example.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String renderPage(ModelMap map) {
    List<User> listUser = userService.getAllUsers();
    map.addAttribute("listUser", listUser);
    map.addAttribute("user", new User());
    return "login";
    // return new ModelAndView("chat");
  }
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@ModelAttribute("user")User user, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      return "error";
    }
    List<User> listUser = userService.getAllUsers();
    model.addAttribute("listUser", listUser);
    model.addAttribute("user", user.getId());
    return "chat";
  }

  @GetMapping("/user/getAll")
  public List<User> all() {
    System.out.print(userService.getAllUsers());
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> createMember(@PathVariable(value= "id") Long id) {
    return ResponseEntity.ok(userService.findUserById(id));
  }
}