package org.training.javatraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.javatraining.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
