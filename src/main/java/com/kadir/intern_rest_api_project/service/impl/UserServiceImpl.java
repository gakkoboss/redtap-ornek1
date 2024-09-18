package com.kadir.intern_rest_api_project.service.impl;

import com.kadir.intern_rest_api_project.Config.ModelMapperConfig;
import com.kadir.intern_rest_api_project.dto.UserDto;
import com.kadir.intern_rest_api_project.entity.User;
import com.kadir.intern_rest_api_project.repository.UserRepository;
import com.kadir.intern_rest_api_project.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resultUser = userRepository.findById(id);

        if (resultUser.isPresent()) {
            resultUser.get().setFirst_name(user.getFirst_name());
            resultUser.get().setLast_name(user.getLast_name());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdateBy("Admin");
            return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}