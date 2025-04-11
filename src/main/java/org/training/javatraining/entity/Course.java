package org.training.javatraining.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private int credits;

    // A course is taught by one Teacher (teacher_id is foreign key in "courses" table)
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // Many students can enroll in many courses
    @ManyToMany
    @JoinTable(name = "enrollments", // intermediate join table
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    public Course() {}

    public Course(String courseName, int credits, Teacher teacher) {
        this.courseName = courseName;
        this.credits = credits;
        this.teacher = teacher;
    }

}