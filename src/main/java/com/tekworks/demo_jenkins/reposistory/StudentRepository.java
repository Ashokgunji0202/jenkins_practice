package com.tekworks.demo_jenkins.reposistory;

import com.tekworks.demo_jenkins.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}