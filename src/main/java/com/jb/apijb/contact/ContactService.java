package com.jb.apijb.contact;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService extends GenericMappingService<ContactDTO, Contact> {

    private final ContactRepository contactRepository;

    public ContactService(final ContactRepository contactRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.contactRepository = contactRepository;
    }

    /**
     * Récupère la liste des coordonnées de contact
     *
     * @return list contactDTO
     */
    public List<ContactDTO> getAllContactInfo() {
        return this.mapListToDto(contactRepository.findAll(), ContactDTO.class);
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
        return this.mapToDto(contactRepository.save(this.mapToEntity(contactDTO, Contact.class)), ContactDTO.class);
    }

    /**
     * Supprime une coordonnée en fonction de son id
     *
     * @param id contact id
     */
    public void deleteContactInfoById(long id) {
        contactRepository.deleteById(id);
    }
}
