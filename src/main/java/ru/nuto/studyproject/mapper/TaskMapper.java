package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import ru.nuto.studyproject.dto.TaskDto;
import ru.nuto.studyproject.model.Task;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toModel(TaskDto taskDto);

    TaskDto toDto(Task task);

    List<Task> toModel(List<TaskDto> tasksDto);

    List<TaskDto> toDto(List<Task> tasks);
}
