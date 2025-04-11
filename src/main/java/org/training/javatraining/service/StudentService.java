package org.training.javatraining.service;


import org.springframework.stereotype.Service;
import org.training.javatraining.dto.StudentDto;
import org.training.javatraining.entity.Student;
import org.training.javatraining.exception.NotFoundException;
import org.training.javatraining.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(StudentDto studentDto) {
        // Convert DTO -> Entity
        Student student = new Student(
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getDateOfBirth(),
                studentDto.getEnrollmentDate(),
                studentDto.getMajor()
        );
        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }

    // UPDATE
    public Student updateStudent(Long id, StudentDto studentDto) {
        Student existing = getStudentById(id);
        existing.setFirstName(studentDto.getFirstName());
        existing.setLastName(studentDto.getLastName());
        existing.setDateOfBirth(studentDto.getDateOfBirth());
        existing.setEnrollmentDate(studentDto.getEnrollmentDate());
        existing.setMajor(studentDto.getMajor());

        return studentRepository.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}
