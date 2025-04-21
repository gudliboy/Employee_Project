package com.example.testApp.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRequestDto {

    @NotNull
    private Long testId;

    @NotEmpty(message = "Name is compulsory")
    @Size(min = 2, message = "name should have atleast 2 chars")
    private String name;

    @NotEmpty(message = "Email is compulsory")
    @Email(message = "email should be in valid format")
    private String email;


}
