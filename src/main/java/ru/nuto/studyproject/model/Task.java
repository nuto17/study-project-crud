package ru.nuto.studyproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "subject_id")
    private List<Subject> subjects;

    private Date timeStart;

    private Date timeEnd;

}
