package com.jb.apijb.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact getInformationsContactPage() {
        long id = 5;
        Optional<Contact> contactResponse = contactRepository.findById(id);

        return contactResponse.get();
    }

    public void createInformationsContactPage(Contact contact) {
        contactRepository.save(new Contact(contact.getAddress(), contact.getPhoneNumber(), contact.getEmail()));
    }
}
