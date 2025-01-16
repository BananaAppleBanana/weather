package com.example.schoolapplication.service.impl;


import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.entity.Teacher;
import com.example.schoolapplication.entity.dto.StudentDTO;
import com.example.schoolapplication.repository.StudentRepository;
import com.example.schoolapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> fetchAllStudentsByAge(Integer age) {
        List<Student> students =  studentRepository.fetchAll(age);
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Age: " + student.getAge());
        }

        return students.stream().map(student -> {
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setAge(student.getAge());
//            dto.setTeacherNames(student.getTeachers().stream()
//                    .map(Teacher::getName)
//                    .collect(Collectors.toSet()));
            return dto;
        }).toList();
    }

    @Override
    public Student fetchStudentById(int id) {
        return studentRepository.fetchById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return studentRepository.update(id, student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Teacher> fetchTeachersByStudentId(int studentId) {
        return studentRepository.fetchTeachersByStudentId(studentId);
    }

    @Override
    public String verify(Student user) {
        return "";
    }
}