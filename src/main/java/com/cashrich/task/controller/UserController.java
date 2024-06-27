package com.cashrich.task.controller;

import com.cashrich.task.payload.UserDto;
import com.cashrich.task.response.ResponseHandler;
import com.cashrich.task.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto) {
        UserDto createUserDto = this.userService.signUp(userDto);
        return ResponseHandler.responseBuilder("User Registered successfully", HttpStatus.OK, createUserDto);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateEmp(@val @RequestBody UserDto userDto, @PathVariable("id") Long id){
        UserDto updateUser = this.userService.updateUser(userDto, id);
        return ResponseHandler.responseBuilder("User updated successfully", HttpStatus.OK,updateUser);
    }

}
