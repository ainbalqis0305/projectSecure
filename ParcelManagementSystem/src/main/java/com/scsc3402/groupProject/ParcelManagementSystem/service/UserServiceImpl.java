package com.scsc3402.groupProject.ParcelManagementSystem.service;

import com.scsc3402.groupProject.ParcelManagementSystem.dto.UserDto;
import com.scsc3402.groupProject.ParcelManagementSystem.model.Role;
import com.scsc3402.groupProject.ParcelManagementSystem.model.User;
import com.scsc3402.groupProject.ParcelManagementSystem.repository.RoleRepository;
import com.scsc3402.groupProject.ParcelManagementSystem.repository.UserRepository;
import com.scsc3402.groupProject.ParcelManagementSystem.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null) {
            role = roleRepository.save(new Role(TbConstants.Roles.USER));
        }

        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

