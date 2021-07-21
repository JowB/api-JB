package com.jb.apijb.message;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends GenericMappingService<MessageDTO, Message> {

    private final MessageRepository messageRepository;

    public MessageService(final MessageRepository messageRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.messageRepository = messageRepository;
    }

    /**
     * Récupère la liste des messages
     *
     * @return list messageDto {@link MessageDTO}
     */
    public List<MessageDTO> getAllMessages() {
        return this.mapListToDto(messageRepository.findAll(), MessageDTO.class);
    }


    /**
     * Permet de faire aussi bien l'insert que l'update en bdd
     *
     * @param messageDTO {@link MessageDTO}
     * @return messageDTO from database {@link MessageDTO}
     */
    public MessageDTO upsertMessage(MessageDTO messageDTO) {
        return this.mapToDto(messageRepository.save(this.mapToEntity(messageDTO, Message.class)), MessageDTO.class);
    }

    /**
     * Supprimer un message en fonction de son id
     *
     * @param id message id
     */
    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }
}