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

    public Task updateTask(Long id, Task task) throws NotFoundTaskException {
        Task taskById = getTaskById(id);
        Task buildedTask = Task.builder()
                .id(taskById.getId())
                .subjectName(task.getSubjectName())
                .timeStart(task.getTimeStart())
                .timeEnd(task.getTimeEnd())
                .build();
        Task updatedTask = taskRepository.save(buildedTask);
        return updatedTask;
    }

    public List<Task> getTasks() {
        List<Task> allTasks = taskRepository.findAll();
        return allTasks;
    }
}
