package org.training.javatraining.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "TeacherDto", description = "DTO for creating/updating teacher data")
public class TeacherDto {

    @Schema(description = "Teacher's first name", example = "Alice")
    private String firstName;

    @Schema(description = "Teacher's last name", example = "Smith")
    private String lastName;

    @Schema(description = "Teacher's date of birth in yyyy-MM-dd format", example = "1980-01-05")
    private LocalDate dateOfBirth;

    @Schema(description = "Date the teacher was hired (yyyy-MM-dd)", example = "2010-09-01")
    private LocalDate hireDate;

    @Schema(description = "The subject taught by the teacher", example = "Mathematics")
    private String subject;

    public TeacherDto(String firstName,
                      String lastName,
                      LocalDate dateOfBirth,
                      LocalDate hireDate,
                      String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hireDate = hireDate;
        this.subject = subject;
    }
}