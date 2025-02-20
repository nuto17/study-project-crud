package ru.nuto.studyproject.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubjectDto {

    private Long id;

    private String name;
}
