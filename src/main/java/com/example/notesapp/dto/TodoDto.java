package com.example.notesapp.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private UUID id;
    private boolean status;
    private String tasks;


}
