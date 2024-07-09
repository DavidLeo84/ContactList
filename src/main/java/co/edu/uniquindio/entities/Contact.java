package co.edu.uniquindio.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createAt;

    @Builder
    public Contact(String name, String email, String phone, LocalDateTime createAt) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createAt = createAt;
    }
}
