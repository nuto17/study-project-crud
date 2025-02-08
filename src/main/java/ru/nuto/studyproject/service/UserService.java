package ru.nuto.studyproject.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nuto.studyproject.model.User;
import ru.nuto.studyproject.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserById(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        return userById;
    }

    public void deleteUser(Long id) {
        User userById = getUserById(id);
        userRepository.delete(userById);
    }

    public User updateUser(Long id, User user) {
        User userById = getUserById(id);

        User buildedUser = User.builder()
                .id(userById.getId())
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .build();

        User updatedUser = userRepository.save(buildedUser);
        return updatedUser;
    }
}
