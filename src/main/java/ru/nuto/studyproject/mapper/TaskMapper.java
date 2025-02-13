package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nuto.studyproject.dto.TaskDto;
import ru.nuto.studyproject.model.Task;
import java.util.List;

@Mapper(componentModel = "spring",uses = SubjectMapper.class)
public interface TaskMapper {

    @Mapping(source = "subjectsIds", target = "subjects")
    Task toModel(TaskDto taskDto);

    @Mapping(source = "subjects", target = "subjectsIds")
    TaskDto toDto(Task task);

    List<Task> toModel(List<TaskDto> tasksDto);
    List<TaskDto> toDto(List<Task> tasks);

}
