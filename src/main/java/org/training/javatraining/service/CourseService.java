package org.training.javatraining.service;
import org.springframework.stereotype.Service;
import org.training.javatraining.dto.CourseDto;
import org.training.javatraining.entity.Course;
import org.training.javatraining.entity.Teacher;
import org.training.javatraining.exception.NotFoundException;
import org.training.javatraining.repository.CourseRepository;
import org.training.javatraining.repository.TeacherRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository,
                         TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    // CREATE
    public Course createCourse(CourseDto courseDto) {
        Teacher teacher = fetchTeacherIfProvided(courseDto.getTeacherId());
        Course course = new Course(
                courseDto.getCourseName(),
                courseDto.getCredits(),
                teacher
        );
        return courseRepository.save(course);
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // READ BY ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id " + id));
    }

    // UPDATE
    public Course updateCourse(Long id, CourseDto courseDto) {
        Course existing = getCourseById(id);

        Teacher teacher = fetchTeacherIfProvided(courseDto.getTeacherId());
        existing.setCourseName(courseDto.getCourseName());
        existing.setCredits(courseDto.getCredits());
        existing.setTeacher(teacher);

        return courseRepository.save(existing);
    }

    // DELETE
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NotFoundException("Course not found with id " + id);
        }
        courseRepository.deleteById(id);
    }

    // Helper method
    private Teacher fetchTeacherIfProvided(Long teacherId) {
        if (teacherId == null) {
            return null; // Or throw an exception if teacher is strictly required
        }
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NotFoundException("Teacher not found with id " + teacherId));
    }
}
