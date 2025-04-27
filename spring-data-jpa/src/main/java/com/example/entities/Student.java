package com.example.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    // @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> course;
}
