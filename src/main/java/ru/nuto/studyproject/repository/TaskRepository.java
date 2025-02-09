package ru.nuto.studyproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nuto.studyproject.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
