package ru.nuto.studyProject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nuto.studyProject.model.User;
import ru.nuto.studyProject.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
