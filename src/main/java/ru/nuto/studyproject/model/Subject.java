package ru.nuto.studyproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
@Data
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private List<Task> tasks;

}
