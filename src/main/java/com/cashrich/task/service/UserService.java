package com.cashrich.task.service;

import com.cashrich.task.entity.User;
import com.cashrich.task.payload.UserDto;

public interface UserService {

    UserDto signUp(UserDto userDto);

    UserDto updateUser(UserDto userDto, Long id);


}
