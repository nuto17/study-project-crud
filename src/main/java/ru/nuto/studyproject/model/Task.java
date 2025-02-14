package ru.nuto.studyproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false)
    private Subject subject;

    private Date timeStart;

    private Date timeEnd;

}
