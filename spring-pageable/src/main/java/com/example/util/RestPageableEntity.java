package com.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestPageableEntity<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
}
