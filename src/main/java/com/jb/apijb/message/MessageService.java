package com.jb.apijb.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public void createMessage(Message message) {
        messageRepository.save(new Message(message.getEmail(), message.getContent()));
    }

    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }
}
