package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nuto.studyproject.dto.SubjectDto;
import ru.nuto.studyproject.model.Subject;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "tasks",ignore = true)
    Subject toModel(SubjectDto subjectDto);

    SubjectDto toDto(Subject subject);

    List<SubjectDto> toDto(List<Subject> subjects);

    List<Subject> toModel(List<SubjectDto> subjectDtos);
}
