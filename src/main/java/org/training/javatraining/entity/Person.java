package org.training.javatraining.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "persons") // or "people"
@Inheritance(strategy = InheritanceType.JOINED) // Each subclass gets its own table, with common fields in persons
@DiscriminatorColumn(name = "person_type") // optional: for Single Table or Joined
@Getter
@Setter
@ToString
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    // Optionally, you could add fields like:
    // private String email;
    // private String phoneNumber;

    // Constructors
    public Person() {}

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


}