package ru.nuto.studyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nuto.studyproject.exception.NotFoundTaskException;
import ru.nuto.studyproject.model.Task;
import ru.nuto.studyproject.repository.TaskRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return savedTask;
    }

    public Task getTaskById(Long id) throws NotFoundTaskException {
        Task taslById = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundTaskException(id));
        return taslById;
    }

    public void deleteTask(Long id) throws NotFoundTaskException {
        Task taskById = getTaskById(id);
        taskRepository.delete(taskById);
    }

    public List<Task> getTasks() {
        List<Task> allTasks = taskRepository.findAll();
        return allTasks;
    }

    public Task updateTask(Long id, Task task) throws NotFoundTaskException {
        Task taskById = getTaskById(id);
        Task updatedTask = Task.builder()
                .id(taskById.getId())
                .subjects(task.getSubjects())
                .timeStart(task.getTimeStart())
                .timeEnd(task.getTimeEnd())
                .build();

        Task saved = taskRepository.save(updatedTask);
        return saved;
    }
}

