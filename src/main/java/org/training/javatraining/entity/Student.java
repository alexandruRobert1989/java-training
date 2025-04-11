package org.training.javatraining.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    private LocalDate enrollmentDate;
    private String major;

    // Many-to-many relationship with Course
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public Student() {}

    public Student(String firstName, String lastName, LocalDate dateOfBirth,
                   LocalDate enrollmentDate, String major) {
        super(firstName, lastName, dateOfBirth);
        this.enrollmentDate = enrollmentDate;
        this.major = major;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
