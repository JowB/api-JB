package com.jb.apijb.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public ResponseEntity<List<ContactDTO>> getAllInfoContact() {
        try {
            List<ContactDTO> contactDTOList = contactService.getAllContactInfo();

            if (contactDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contactDTOList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getInfoFromContactById(@PathVariable("id") long id) {
        try {
            Optional<Contact> contactOptional = contactService.getContactInfoById(id);

            return contactOptional.map(info -> new ResponseEntity<>(info, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> upsertContactInfo(@RequestBody ContactDTO contactDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contactService.upsertContact(contactDTO));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContactInfoById(@PathVariable("id") long id) {
        try {
            contactService.deleteContactInfoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
