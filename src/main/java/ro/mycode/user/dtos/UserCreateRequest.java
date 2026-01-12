package ro.mycode.user.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(


        @NotBlank(message = "Username-ul este obligatoriu")
        @Size(min = 3, max = 50, message = "Username>3, <5")
        @Pattern(regexp= "^[a-zA-Z0-9_]+$",message = "Username-ul poate contine doar litere")
        @Column(nullable = false,length = 255)
        String username,



        @NotBlank(message = "Email-ul este obligatoriu")
        @Email(message = "Format email invalid")
        @Column(nullable = false,length = 255)
        String email


) {
}
