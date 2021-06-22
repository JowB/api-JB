package com.jb.apijb.contact;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactService(final ContactRepository contactRepository, final ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    public Contact getInformationsContactPage() {
        long id = 5;
        Optional<Contact> contactResponse = contactRepository.findById(id);

        return contactResponse.get();
    }

    public void createInformationsContactPage(Contact contact) {
        contactRepository.save(new Contact(contact.getAddress(), contact.getPhoneNumber(), contact.getEmail()));
    }

    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> findContact(long id) {
        return contactRepository.findById(id);
    }

    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }

    private Contact mapToEntity(ContactDTO contactDTO) {
        return modelMapper.map(contactDTO, Contact.class);
    }

    private ContactDTO mapToDto(Contact contact) {
        return modelMapper.map(contact, ContactDTO.class);
    }
}
