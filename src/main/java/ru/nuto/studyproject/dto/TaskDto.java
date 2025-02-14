package ru.nuto.studyproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {

    private Long id;

    private Long subjectId;

    private Date timeStart;

    private Date timeEnd;

}
