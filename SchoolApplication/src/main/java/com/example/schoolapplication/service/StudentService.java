package com.example.schoolapplication.service;

import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.entity.Teacher;
import com.example.schoolapplication.entity.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> fetchAllStudentsByAge(Integer age);
    Student fetchStudentById(int id);
    Student saveStudent(Student student);
    Student updateStudent(int id, Student student);
    void deleteStudent(int id);
    List<Teacher> fetchTeachersByStudentId(int studentId);

    String verify(Student user);
}
