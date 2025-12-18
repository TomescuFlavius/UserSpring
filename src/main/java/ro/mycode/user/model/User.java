package ro.mycode.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.context.annotation.Primary;


@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Username-ul este obligatoriu")
    @Size(min = 3, max = 50, message = "Username>3, <5")
    @Pattern(regexp= "^[a-zA-Z0-9_]+$",message = "Username-ul poate contine doar litere")
    @Column(nullable = false,length = 255)
    private String username;

    @NotBlank(message = "Email-ul este obligatoriu")
    @Email(message = "Format email invalid")
    @Column(nullable = false,length = 255)
    private String email;


}
