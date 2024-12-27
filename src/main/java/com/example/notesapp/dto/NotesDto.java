package com.example.notesapp.dto;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class NotesDto {
    long id;
    String description;
    String createdBy;
}
