package com.example.chat.services;
import com.example.chat.models.User;
import com.example.chat.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User findUserById(Long id) {
      return userRepository.findById(id).orElse(null);
  }

  public List<User> getAllUsers() {
      return userRepository.findAll();
  }
}
