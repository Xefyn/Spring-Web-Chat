package com.example.chat.repositories;
import java.util.List;

import com.example.chat.models.Chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("chatRepository")
public interface ChatRepository extends JpaRepository<Chat, Long>  {
  @Query(value = "select c.id as id, u.id as user_sender_id, (select user.id from user where user.id = c.user_receiver_id) as user_receiver_id, message, created_at from chat c inner join user u on u.id = c.user_sender_id where c.user_sender_id = :sender || c.user_receiver_id = :sender && c.user_receiver_id = :receiver || c.user_sender_id = :receiver order by created_at asc", nativeQuery = true)
  public List<Chat> getListChat(@Param("sender")Long sender, @Param("receiver")Long receiver);
}