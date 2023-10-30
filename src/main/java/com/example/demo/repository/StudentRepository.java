package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int studentId);

    Student removeById(int studentId);

    Integer add(Student student);
    Student update(int studentId,Student student);
}
