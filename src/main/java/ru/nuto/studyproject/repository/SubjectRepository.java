package ru.nuto.studyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nuto.studyproject.model.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}