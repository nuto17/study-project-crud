package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nuto.studyproject.dto.TaskDto;
import ru.nuto.studyproject.model.Subject;
import ru.nuto.studyproject.model.Task;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id",source = "taskDto.id")
    @Mapping(target = "timeStart",source = "taskDto.timeStart")
    @Mapping(target = "timeEnd",source = "taskDto.timeEnd")
    @Mapping(target = "subject",source = "taskDto.subjectId",qualifiedByName = "mapIdToSubject")
    Task toModel(TaskDto taskDto);

    @Mapping(target = "id", source = "task.id")
    @Mapping(target = "timeStart", source = "task.timeStart")
    @Mapping(target = "timeEnd", source = "task.timeEnd")
    @Mapping(target = "subjectId", source = "task.subject",qualifiedByName = "mapSubjectToId")
    TaskDto toDto(Task task);

    List<Task> toModel(List<TaskDto> tasksDto);
    List<TaskDto> toDto(List<Task> tasks);

    @Named("mapIdToSubject")
    default Subject mapIdsToSubjects(Long id){
        Subject subject = new Subject();
       subject.setId(id);
       return subject;
    }

    @Named("mapSubjectToId")
    default Long mapSubjectToId(Subject subject) {
        return subject.getId();
    }
}
