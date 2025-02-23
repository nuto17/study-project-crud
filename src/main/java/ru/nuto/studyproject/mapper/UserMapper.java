package ru.nuto.studyproject.mapper;

import org.mapstruct.Mapper;
import ru.nuto.studyproject.dto.UserDto;
import ru.nuto.studyproject.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserDto userDto);

    UserDto toDto(User user);

    List<User> toModel(List<UserDto> usersDto);

    List<UserDto> toDto(List<User> users);
}
