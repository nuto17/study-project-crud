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
    @Mapping(target = "subjects",source = "taskDto.subjectsIds",qualifiedByName = "mapIdsToSubjects")
    Task toModel(TaskDto taskDto);

    @Mapping(target = "id", source = "task.id")
    @Mapping(target = "timeStart", source = "task.timeStart")
    @Mapping(target = "timeEnd", source = "task.timeEnd")
    @Mapping(target = "subjectsIds", source = "task.subjects",qualifiedByName = "mapSubjectsToIds")
    TaskDto toDto(Task task);

    List<Task> toModel(List<TaskDto> tasksDto);
    List<TaskDto> toDto(List<Task> tasks);

    @Named("mapIdsToSubjects")
    default List<Subject> mapIdsToSubjects(List<Long> ids){
        List<Subject> subjects = ids.stream()
                .map(id -> {
                    Subject subject = new Subject();
                    subject.setId(id);
                    return subject;
                })
                .toList();

        return subjects;
    }

    @Named("mapSubjectsToIds")
    default List<Long> mapSubjectsToIds(List<Subject> subjects){
        List<Long> idsList = subjects.stream()
                .map(subject -> {
                    Long id = subject.getId();
                    return id;
                })
                .toList();

        return idsList;
    }
}
