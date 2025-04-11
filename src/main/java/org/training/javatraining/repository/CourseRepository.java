package org.training.javatraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.javatraining.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
