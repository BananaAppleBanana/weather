package com.example.schoolapplication;

import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SchoolApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFetchAllStudents() {
        // 查询所有学生
        List<Student> students = studentRepository.fetchAll(null);

        // 打印学生列表
        System.out.println("Fetched Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Age: " + student.getAge());
        }

        // 断言验证
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }


    @Test
    public void testFetchAllStudentsByAge() {
        List<Student> students = studentRepository.fetchAll(22);

        System.out.println("Fetched Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Age: " + student.getAge());
        }

        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(20);

        Student savedStudent = studentRepository.save(student);
        assertNotNull(savedStudent);
        assertNotNull(savedStudent.getId());
    }

}
