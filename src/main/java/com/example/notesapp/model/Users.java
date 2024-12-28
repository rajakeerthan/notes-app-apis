package com.example.notesapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(name="id")
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID Id;

    @Column(name="email")
    @Email(message="email should be valid")
    @NotEmpty(message="email cannot be empty")
    private String email;

    @Column(name="user_name")
    @NotEmpty(message="username cannot be empty")
    private String userName;

    @Column(name="password")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @NotEmpty(message="password cannot be empty")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
//            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.")
    private String password;

//    @Column(name="notes")
//    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//    private List<Note> notes;
//
//    @Column(name="todos")
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Todo> todos;

}
