package ru.nuto.studyProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nuto.studyProject.dto.UserDto;
import ru.nuto.studyProject.mapper.UserMapper;
import ru.nuto.studyProject.model.User;
import ru.nuto.studyProject.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper mapper;
    private final UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        User model = mapper.toModel(userDto);
        User savedUser = userService.saveUser(model);
        UserDto savedUserDto = mapper.toDto(savedUser);
        return savedUserDto;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDto> usersDto = mapper.toDto(users);
        return usersDto;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id,@RequestBody UserDto userDto){
        User user = mapper.toModel(userDto);
        User updatedUser = userService.updateUser(id, user);
        UserDto updatedUserDto = mapper.toDto(updatedUser);
        return updatedUserDto;
    }

}
