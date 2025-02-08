package ru.nuto.studyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nuto.studyProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
