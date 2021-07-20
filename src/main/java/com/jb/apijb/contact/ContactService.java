package com.jb.apijb.contact;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactService(final ContactRepository contactRepository, final ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Récupère la liste des coordonnées de contact
     *
     * @return list contactDTO
     */
    public List<ContactDTO> getAllContactInfo() {
        return this.mapListToDto(contactRepository.findAll());
    }

    /**
     * Récupère une coordonnée de contact en fonction de son id
     *
     * @param id contact id
     * @return optional Contact
     */
    public Optional<Contact> getContactInfoById(long id) {
        return contactRepository.findById(id);
    }

    /**
     * Permet de faire l'ajout ainsi que la modification en bdd
     *
     * @param contactDTO {@link ContactDTO}
     * @return contactDTO {@link ContactDTO}
     */
    public ContactDTO upsertContact(ContactDTO contactDTO) {
        return this.mapToDto(contactRepository.save(this.mapToEntity(contactDTO)));
    }

    /**
     * Supprime une coordonnée en fonction de son id
     *
     * @param id contact id
     */
    public void deleteContactInfoById(long id) {
        contactRepository.deleteById(id);
    }

    private Contact mapToEntity(ContactDTO contactDTO) {
        return modelMapper.map(contactDTO, Contact.class);
    }

    private ContactDTO mapToDto(Contact contact) {
        return modelMapper.map(contact, ContactDTO.class);
    }

    private List<ContactDTO> mapListToDto(List<Contact> contactList) {
        return contactList
                .stream()
                .map(element -> modelMapper.map(element, ContactDTO.class))
                .collect(Collectors.toList());
    }
}
