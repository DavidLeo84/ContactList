package co.edu.uniquindio.dtos;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ContactDTO(
        @PositiveOrZero
        int id,

        @NotBlank(message = "El campo nombre no puede ser vacío")
        @Length(max = 50, min = 3)
        String name,

        @Email(message = "El email es invalido")
        @NotBlank(message = "El campo email no puede ser vacío")
        @NotNull(message = "El email es requerido")
        @Length(max = 50)
        String email,

        @Length(max = 10, message = "Numéro de telefono no es válido")
        String phone,

        LocalDateTime createdAt
) {
}
