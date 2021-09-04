package com.lessonone.lessonone.controller;

import com.lessonone.lessonone.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //TODO Разобраться с запросами
    Optional<Student> findStudentByEmail(String email);
}
