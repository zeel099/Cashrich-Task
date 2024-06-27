package com.cashrich.task.security;

import com.cashrich.task.entity.User;
import com.cashrich.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(user_name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + user_name));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
