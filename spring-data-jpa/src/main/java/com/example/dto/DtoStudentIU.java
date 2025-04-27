package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Firstname cannot be empty!")
    @Min(value = 3)
    @Max(value = 10)
    private String firstName;

    @Size(min = 3, max = 30)
    private String lastName;
    private LocalDate birthDate;

    @Email(message = "Enter to right mail!")
    private String mail;

    @Size(min = 11, max =11, message = "TCK should be 11 character!")
    @NotEmpty(message = "Tck area cannot be empty!")
    private String tck;
}
