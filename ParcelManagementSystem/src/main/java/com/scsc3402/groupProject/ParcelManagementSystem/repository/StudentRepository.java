package com.scsc3402.groupProject.ParcelManagementSystem.repository;

import com.scsc3402.groupProject.ParcelManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
