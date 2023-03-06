package com.jobi.studentservice.dto;
import jakarta.persistence.Column;
import lombok.Data;

@Data
//DTO -> Data Transfer Object
public class StudentDto {
    private Long studentId;
    private String email;
    private String firstName;
    private String lastName;
    private String course;
}
