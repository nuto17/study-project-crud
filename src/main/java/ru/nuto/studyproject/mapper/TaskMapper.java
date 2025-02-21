package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nuto.studyproject.dto.SubjectDto;
import ru.nuto.studyproject.dto.TaskDto;
import ru.nuto.studyproject.model.Subject;
import ru.nuto.studyproject.model.Task;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id",source = "taskDto.id")
    @Mapping(target = "subject",source = "taskDto.subjectDto",qualifiedByName = "mapSubjectDtoToSubject")
    @Mapping(target = "timeStart",source = "taskDto.timeStart")
    @Mapping(target = "timeEnd",source = "taskDto.timeEnd")
    Task toModel(TaskDto taskDto);

    @Mapping(target = "id",source = "task.id")
    @Mapping(target = "subjectDto",source = "task.subject",qualifiedByName = "mapSubjectToSubjectDto")
    @Mapping(target = "timeStart",source = "task.timeStart")
    @Mapping(target = "timeEnd",source = "task.timeEnd")
    TaskDto toDto(Task task);

    List<Task> toModel(List<TaskDto> tasksDto);

    List<TaskDto> toDto(List<Task> tasks);

    @Named("mapSubjectDtoToSubject")
    default Subject mapSubjectDtoToSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        return subject;
    }

    @Named("mapSubjectToSubjectDto")
    default SubjectDto mapSubjectToSubjectDto(Subject subject){
        SubjectDto builtSubjectDto = SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
        return builtSubjectDto;
    }
}
