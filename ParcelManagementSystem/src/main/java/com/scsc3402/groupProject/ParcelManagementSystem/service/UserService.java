package com.scsc3402.groupProject.ParcelManagementSystem.service;

import com.scsc3402.groupProject.ParcelManagementSystem.dto.UserDto;
import com.scsc3402.groupProject.ParcelManagementSystem.model.User;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail (String email);

}
