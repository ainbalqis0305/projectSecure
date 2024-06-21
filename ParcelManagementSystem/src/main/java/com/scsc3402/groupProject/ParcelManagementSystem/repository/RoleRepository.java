package com.scsc3402.groupProject.ParcelManagementSystem.repository;

import com.scsc3402.groupProject.ParcelManagementSystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
