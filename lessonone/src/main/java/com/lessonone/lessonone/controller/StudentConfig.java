package com.lessonone.lessonone.controller;

import com.lessonone.lessonone.bean.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student = new Student(
                    1L,
                    "Mariam",
                    "email@mail.com",
                    LocalDate.of(2000, Month.APRIL, 1)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@mail.com",
                    LocalDate.of(2001, Month.APRIL, 1)
            );
            studentRepository.saveAll(List.of(student, alex));
        };
    }
}
