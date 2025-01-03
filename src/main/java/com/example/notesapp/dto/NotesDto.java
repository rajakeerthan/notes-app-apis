package com.example.notesapp.dto;

import lombok.*;

import java.util.UUID;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class NotesDto {
    private UUID id;
    private String description;
    private String createdBy;

}
