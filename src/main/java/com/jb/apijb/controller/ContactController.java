package com.jb.apijb.controller;

import com.jb.apijb.model.Contact;
import com.jb.apijb.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> getInformationsContactPage() {
        try {
            List<Contact> contact = contactRepository.findAll();

            if (contact.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> createInformationsContactPage(@RequestBody Contact contact) {
        try {
            Contact newContact = contactRepository.save(new Contact(contact.getAddress(), contact.getPhoneNumber(), contact.getEmail(), contact.getLinkedinUrl(), contact.getGitlabUrl(), contact.getGithubUrl()));
            return new ResponseEntity<>(newContact, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
