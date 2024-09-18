package com.kadir.intern_rest_api_project.service;

import com.kadir.intern_rest_api_project.dto.UserDto;
import com.kadir.intern_rest_api_project.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    List<UserDto>getUsers();
    UserDto getUser(Long id);
    UserDto updateUser(Long id, UserDto user);
    Boolean deleteUser(Long id);
}
