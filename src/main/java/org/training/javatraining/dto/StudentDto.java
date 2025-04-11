package org.training.javatraining.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    @Schema(description = "The student's first name", example = "John")
    private String firstName;

    @Schema(description = "The student's last name", example = "Doe")
    private String lastName;

    @Schema(description = "Date of birth in ISO format (yyyy-MM-dd)", example = "2000-05-10")
    private LocalDate dateOfBirth;

    @Schema(description = "Date the student enrolled", example = "2023-09-01")
    private LocalDate enrollmentDate;

    @Schema(description = "Major or field of study", example = "Computer Science")
    private String major;

}