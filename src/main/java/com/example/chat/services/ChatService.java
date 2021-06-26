package com.example.chat.services;
import com.example.chat.models.Chat;
import com.example.chat.repositories.ChatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("chatService")
public class ChatService {
  @Autowired
  private ChatRepository chatRepository;

  public List<Chat> getListChat(Long sender_id, Long receiver_id) {
    List<Chat> listChat = chatRepository.getListChat(sender_id, receiver_id);
    return listChat;
  }

  public void insertChat(Long sender_id, Long receiver_id, String message) {
    chatRepository.insertChat(sender_id, receiver_id, message);
  }
}
