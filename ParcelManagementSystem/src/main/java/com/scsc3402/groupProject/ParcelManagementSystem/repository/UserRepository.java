package com.scsc3402.groupProject.ParcelManagementSystem.repository;

import com.scsc3402.groupProject.ParcelManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
