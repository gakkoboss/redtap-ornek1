package com.kadir.intern_rest_api_project.api;


import com.kadir.intern_rest_api_project.dto.UserDto;
import com.kadir.intern_rest_api_project.entity.User;
import com.kadir.intern_rest_api_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        UserDto user = userService.getUser(id);
    return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) {
        UserDto resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Long id) {
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);

    }
}