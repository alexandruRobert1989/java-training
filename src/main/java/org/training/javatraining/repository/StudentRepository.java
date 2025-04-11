package org.training.javatraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.javatraining.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {
}
