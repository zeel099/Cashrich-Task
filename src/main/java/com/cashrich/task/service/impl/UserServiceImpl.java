package com.cashrich.task.service.impl;

import com.cashrich.task.entity.User;
import com.cashrich.task.payload.UserDto;
import com.cashrich.task.repository.UserRepository;
import com.cashrich.task.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto signUp(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);
        User savedUser = this.userRepository.save(user);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setMobileNo(userDto.getMobileNo());

        User updatedUser = this.userRepository.save(user);
        return this.modelMapper.map(updatedUser,UserDto.class);
    }
}
