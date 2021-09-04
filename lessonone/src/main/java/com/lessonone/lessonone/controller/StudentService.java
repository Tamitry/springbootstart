package com.lessonone.lessonone.controller;

import com.lessonone.lessonone.bean.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        Optional<Student> studentOptional =
                studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("Student doesn't exist.");
        }
        studentRepository.delete(studentOptional.get());
    }

    @Transactional
    public void updateStudent(long id, String name, String email) {
        Optional<Student> studentOptional =
                studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("Student doesn't exist.");
        }
        if (name != null && name.length() > 0
                && !name.equals(studentOptional.get().getName())) {
            studentOptional.get().setName(name);
        }
        if (email != null && email.length() > 0
                && !email.equals(studentOptional.get().getEmail())) {
                if (studentRepository.findStudentByEmail(email).isPresent()) {
                    throw new IllegalStateException("Email is taken.");
                }
            studentOptional.get().setEmail(email);
        }
    }
}
