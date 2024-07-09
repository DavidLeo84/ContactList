package co.edu.uniquindio.services;


import co.edu.uniquindio.dtos.ContactDTO;
import co.edu.uniquindio.entities.Contact;
import co.edu.uniquindio.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.repositories.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepo contactRepo;


    @Override
    public Contact createContact(ContactDTO contactDTO) throws Exception {
        Optional<Contact> optional = contactRepo.findByEmail(contactDTO.email().toLowerCase());
        if (optional.isPresent()) {
            throw new Exception("El correo ya existe");
        }
        Contact contact = Contact
                .builder()
                .name(contactDTO.name())
                .email(contactDTO.email())
                .phone(contactDTO.phone())
                .createAt(LocalDateTime.now())
                .build();

        contactRepo.save(contact);
        return contact;
    }

    @Override
    public Contact updateContact(int id, ContactDTO contactDTO) throws ResourceNotFoundException {

        Contact contact = findById(id);
        contact.setName(contactDTO.name());
        contact.setEmail(contactDTO.email());
        contact.setPhone(contactDTO.phone());
        contactRepo.save(contact);
        return contact;
    }


    @Override
    public void deleteContact(int id) throws ResourceNotFoundException {

        Contact contact = findById(id);
        contactRepo.deleteById(id);
    }

    @Override
    public ContactDTO getContact(int id) throws ResourceNotFoundException {

        Contact contact = findById(id);
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getCreateAt()
        );
    }

    @Override
    public List<ContactDTO> getContacts() throws Exception {

        List<Contact> contactList = contactRepo.findAll();
        return contactList.stream()
                .map(c -> new ContactDTO(
                        c.getId(),
                        c.getName(),
                        c.getEmail(),
                        c.getPhone(),
                        c.getCreateAt()))
                .toList();
    }

    private Contact findById(int id) throws ResourceNotFoundException {

        Optional<Contact> optional = contactRepo.findById(id);
        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("El contacto no existe");
        }
        Contact contact = optional.get();
        return contact;
    }
}
