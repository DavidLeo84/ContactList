package co.edu.uniquindio.services;


import co.edu.uniquindio.dtos.ContactDTO;
import co.edu.uniquindio.entities.Contact;
import co.edu.uniquindio.excepciones.ResourceNotFoundException;

import java.util.List;

public interface IContactService {

    Contact createContact(ContactDTO contactDTO) throws Exception;

    Contact updateContact(int id, ContactDTO contactDTO) throws ResourceNotFoundException;

    void deleteContact(int id) throws ResourceNotFoundException;

    ContactDTO getContact(int id) throws ResourceNotFoundException;

    List<ContactDTO> getContacts() throws Exception;
}
