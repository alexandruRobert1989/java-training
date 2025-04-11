package org.training.javatraining.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    private LocalDate hireDate;
    private String subject;

    // A teacher can have multiple Courses
    @OneToMany(mappedBy = "teacher")
    private List<Course> coursesTaught = new ArrayList<>();

    public Teacher() {}

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth,
                   LocalDate hireDate, String subject) {
        super(firstName, lastName, dateOfBirth);
        this.hireDate = hireDate;
        this.subject = subject;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
}
