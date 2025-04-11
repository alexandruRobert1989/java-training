package org.training.javatraining.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CourseDto", description = "DTO for creating/updating a Course")
public class CourseDto {

    @Schema(description = "Name of the course", example = "Calculus 101")
    private String courseName;

    @Schema(description = "Number of credits for this course", example = "3")
    private int credits;

    @Schema(description = "Teacher ID associated with the course (if any)", example = "1")
    private Long teacherId;

    public CourseDto(String courseName, int credits, Long teacherId) {
        this.courseName = courseName;
        this.credits = credits;
        this.teacherId = teacherId;
    }
}