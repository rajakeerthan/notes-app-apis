package com.example.notesapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(name="tasks", columnDefinition = "TEXT")
    private String tasks;

    @Column(name="status")
    private Boolean status;

    @Column(name="due_date")
    private Timestamp dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
