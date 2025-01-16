package com.example.schoolapplication.repository.impl;


import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.entity.Teacher;
import com.example.schoolapplication.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    //Hibernate 最早诞生时并没有 JPA 标准，使用它原生的 SessionFactory 和 Session.
    // 但是为了符合 JPA 标准（Java Persistence API），Hibernate 提供了一个对 JPA EntityManager的实现，
    // 这个实现是通过在内部封装了 Hibernate 的 SessionFactory 和 Session 来完成的。

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> fetchAll(Integer age) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Student";
            if (age != null) {
                hql += " where age = :age";
            }
            var query = session.createQuery(hql, Student.class);
            if (age != null) {
                query.setParameter("age", age);
            }
            return query.list();
        }
    }

    @Override
    public Student fetchById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
//    @Transactional
    public Student save(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student update(int id, Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student existingStudent = session.get(Student.class, id);
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            session.update(existingStudent);
            session.getTransaction().commit();
            return existingStudent;
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Teacher> fetchTeachersByStudentId(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = """
            SELECT st.teacher
            FROM StudentTeacher st
            WHERE st.student.id = :studentId
        """;
            var query = session.createQuery(hql, Teacher.class);
            query.setParameter("studentId", studentId);
            return query.list();
        }
    }
}




//自定义 StudentRepository
//首先定义一个接口 StudentRepositoryCustom
//提供自定义实现类 @Repository
//public class StudentRepositoryCustomImpl implements StudentRepositoryCustom
//Spring Data JPA 会自动检测以 CustomImpl 为后缀的实现类。因此，你需要将你的 StudentRepository 修改为：
//public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom
//然后你就可以 通过 StudentRepository 调用自定义的方法




















