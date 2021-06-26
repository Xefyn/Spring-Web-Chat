package com.example.chat.controllers;

import com.example.chat.models.User;
import com.example.chat.models.Chat;
import com.example.chat.services.UserService;
import com.example.chat.services.ChatService;

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
  @Autowired
  private ChatService chatService;

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
    User activeUser = userService.findUserById(user.getId());
    model.addAttribute("listUser", listUser);
    model.addAttribute("activeUser", activeUser);
    model.addAttribute("friend", new User());
    return "chat";
  }
  @RequestMapping(value = "/selectFriend", method = RequestMethod.POST)
  public String selectFriend(@RequestParam String id, @RequestParam String name, @RequestParam String activeId, @RequestParam String activeName, ModelMap model) {
    User friend = new User();
    friend.setId(Long.parseLong(id));
    friend.setName(name);
    User activeUser = new User();
    activeUser.setId(Long.parseLong(activeId));
    activeUser.setName(activeName);
    List<User> listUser = userService.getAllUsers();
    List<Chat> listChat = chatService.getListChat(activeUser.getId(), friend.getId());
    model.addAttribute("friend", friend);
    model.addAttribute("activeUser", activeUser);
    model.addAttribute("listUser", listUser);
    model.addAttribute("listChat", listChat);
    return "chat";
  }

  @RequestMapping(value = "/sendChat", method = RequestMethod.POST)
  public String sendChat(@RequestParam String id, @RequestParam String name, @RequestParam String activeId, @RequestParam String activeName, @RequestParam String chat, ModelMap model) {
    User friend = new User();
    friend.setId(Long.parseLong(id));
    friend.setName(name);
    User activeUser = new User();
    activeUser.setId(Long.parseLong(activeId));
    activeUser.setName(activeName);
    List<User> listUser = userService.getAllUsers();
    model.addAttribute("friend", friend);
    model.addAttribute("activeUser", activeUser);
    model.addAttribute("listUser", listUser);
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