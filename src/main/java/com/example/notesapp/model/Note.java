package com.example.notesapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="note")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  ---for id column(1,2,3)
    @UuidGenerator(style = UuidGenerator.Style.TIME)  // for uuid
    private UUID id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="timestamp")
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
