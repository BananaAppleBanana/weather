package com.example.schoolapplication.controller;


import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.entity.Teacher;
import com.example.schoolapplication.entity.dto.StudentDTO;
import com.example.schoolapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public String login(@RequestBody Student user) {
        return studentService.verify(user);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(@RequestParam(required = false) Integer age) {
        return new ResponseEntity<>(studentService.fetchAllStudentsByAge(age), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.fetchStudentById(id);
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<Teacher>> getTeachersByStudentId(@PathVariable int id) {
        List<Teacher> teachers = studentService.fetchTeachersByStudentId(id);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}