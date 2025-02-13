package ru.nuto.studyproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nuto.studyproject.dto.TaskDto;
import ru.nuto.studyproject.exception.NotFoundTaskException;
import ru.nuto.studyproject.mapper.TaskMapper;
import ru.nuto.studyproject.model.Task;
import ru.nuto.studyproject.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(path = "api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskMapper mapper;
    private final TaskService taskService;

    @PostMapping
    public TaskDto saveTask(@RequestBody TaskDto taskDto) {
        Task task = mapper.toModel(taskDto);
        Task savedTask = taskService.saveTask(task);
        TaskDto savedTaskDto = mapper.toDto(savedTask);
        return savedTaskDto;
    }

    @GetMapping
    public List<TaskDto> tasks() {
        List<Task> tasks = taskService.getTasks();
        List<TaskDto> tasksDto = mapper.toDto(tasks);
        return tasksDto;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) throws NotFoundTaskException {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable("id") Long id, @RequestBody TaskDto taskDto) throws NotFoundTaskException {
        Task task = mapper.toModel(taskDto);
        Task updatedTask = taskService.updateTask(id, task);
        TaskDto updatedTaskDto = mapper.toDto(updatedTask);
        return updatedTaskDto;
    }
}
