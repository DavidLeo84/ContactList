package co.edu.uniquindio;

import co.edu.uniquindio.entities.Contact;
import co.edu.uniquindio.repositories.ContactRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AgendaContactosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaContactosApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ContactRepo contactRepo) {

        return args -> {


            List<Contact> contactList = Arrays.asList(
                    new Contact("David Romero", "leoromero141@gmail.com", "3424324231", LocalDateTime.now()),
                    new Contact("Jorge Toro", "jorge21@gmail.com", "3343544329", LocalDateTime.now()),
                    new Contact("Daniela Mendez", "danimen19@hotmail.com", "3003432423", LocalDateTime.now()),
                    new Contact("Julieta Gutierrez", "julieta_guz75@gmail.com", "3153243537", LocalDateTime.now()),
                    new Contact("Sebastian Ocampo", "ocamposebas66@gmail.com", "3105456456", LocalDateTime.now())
            );
            contactRepo.saveAll(contactList);
        };
    }
}
