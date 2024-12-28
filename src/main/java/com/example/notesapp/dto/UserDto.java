package com.example.notesapp.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private UUID id;

    private String username;


    private String password;


    private String email;

}
