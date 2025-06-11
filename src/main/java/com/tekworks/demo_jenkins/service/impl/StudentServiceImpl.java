package com.tekworks.demo_jenkins.service.impl;


import com.tekworks.demo_jenkins.entity.Student;
import com.tekworks.demo_jenkins.reposistory.StudentRepository;
import com.tekworks.demo_jenkins.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    @PostConstruct
    public void initData() {
        System.out.println("Seeding student table...");

        Student s1 = new Student("Alice", "alice@example.com", 20);
        Student s2 = new Student("Bob", "bob@example.com", 21);
        Student s3 = new Student("Charlie", "charlie@example.com", 22);
        Student s4 = new Student("Diana", "diana@example.com", 23);
        Student s5 = new Student("Ethan", "ethan@example.com", 24);

        repository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());
        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}