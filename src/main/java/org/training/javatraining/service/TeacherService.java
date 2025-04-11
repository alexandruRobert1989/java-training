package org.training.javatraining.service;


import org.springframework.stereotype.Service;
import org.training.javatraining.dto.TeacherDto;
import org.training.javatraining.entity.Teacher;
import org.training.javatraining.exception.NotFoundException;
import org.training.javatraining.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // CREATE
    public Teacher createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher(
                teacherDto.getFirstName(),
                teacherDto.getLastName(),
                teacherDto.getDateOfBirth(),
                teacherDto.getHireDate(),
                teacherDto.getSubject()
        );
        return teacherRepository.save(teacher);
    }

    // READ ALL
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // READ BY ID
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher not found with id " + id));
    }

    // UPDATE
    public Teacher updateTeacher(Long id, TeacherDto teacherDto) {
        Teacher existing = getTeacherById(id);
        existing.setFirstName(teacherDto.getFirstName());
        existing.setLastName(teacherDto.getLastName());
        existing.setDateOfBirth(teacherDto.getDateOfBirth());
        existing.setHireDate(teacherDto.getHireDate());
        existing.setSubject(teacherDto.getSubject());

        return teacherRepository.save(existing);
    }

    // DELETE
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException("Teacher not found with id " + id);
        }
        teacherRepository.deleteById(id);
    }
}