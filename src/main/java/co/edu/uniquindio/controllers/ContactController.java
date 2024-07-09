package co.edu.uniquindio.controllers;

import co.edu.uniquindio.dtos.ContactDTO;
import co.edu.uniquindio.entities.Contact;
import co.edu.uniquindio.services.IContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/agenda")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;

    @GetMapping
    public List<ContactDTO> findAll() throws Exception {
        return contactService.getContacts();
    }

    @GetMapping("{id}")
    public ContactDTO getContact(@PathVariable int id) throws Exception {

        return contactService.getContact(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact createContact(@Valid @RequestBody ContactDTO contactDTO) throws Exception {
        return contactService.createContact(contactDTO);
    }

    @PutMapping("{id}")
    public Contact updateContact(@PathVariable int id,
                                 @Valid @RequestBody ContactDTO contactDTO) throws Exception {
        return contactService.updateContact(id, contactDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable int id) throws Exception {
        contactService.deleteContact(id);
    }

}
