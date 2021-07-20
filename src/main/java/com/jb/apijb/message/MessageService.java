package com.jb.apijb.message;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {


    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MessageService(final MessageRepository messageRepository, final ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Récupère la liste des messages
     *
     * @return list messageDto {@link MessageDTO}
     */
    public List<MessageDTO> getAllMessages() {
        return this.mapListToDto(messageRepository.findAll());
    }


    /**
     * Permet de faire aussi bien l'insert que l'update en bdd
     *
     * @param messageDTO {@link MessageDTO}
     * @return messageDTO from database {@link MessageDTO}
     */
    public MessageDTO upsertMessage(MessageDTO messageDTO) {
        return this.mapToDto(messageRepository.save(this.mapToEntity(messageDTO)));
    }

    /**
     * Supprimer un message en fonction de son id
     *
     * @param id message id
     */
    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }

    private Message mapToEntity(MessageDTO messageDTO) {
        return modelMapper.map(messageDTO, Message.class);
    }

    private MessageDTO mapToDto(Message message) {
        return modelMapper.map(message, MessageDTO.class);
    }

    private List<MessageDTO> mapListToDto(List<Message> messageList) {
        return messageList
                .stream()
                .map(element -> modelMapper.map(element, MessageDTO.class))
                .collect(Collectors.toList());
    }
}