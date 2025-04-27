package com.example.dto;

import com.example.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {
    private Long id;
    private String name;
    private DtoDepartment department;
}
