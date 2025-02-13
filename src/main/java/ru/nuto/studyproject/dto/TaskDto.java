package ru.nuto.studyproject.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class TaskDto {

    private Long id;

    private List<Long> subjectsIds;

    private Date timeStart;

    private Date timeEnd;

}
