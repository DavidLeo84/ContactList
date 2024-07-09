package co.edu.uniquindio.repositories;

import co.edu.uniquindio.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {


    Optional<Contact> findByEmail(String email);

    List<Contact> findAll();
}
