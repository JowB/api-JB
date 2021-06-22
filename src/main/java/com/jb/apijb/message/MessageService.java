package com.jb.apijb.message;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    public MessageService(final MessageRepository messageRepository, final ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }

    private Message mapToEntity(MessageDTO messageDTO) {
        return modelMapper.map(messageDTO, Message.class);
    }

    private MessageDTO mapToDto(Message message) {
        return modelMapper.map(message, MessageDTO.class);
    }
}